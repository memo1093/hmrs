package kodlamaio.hmrs.business.concretes;

import java.util.Map;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.RoleService;
import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.adapters.concretes.ActivationAdapter;
import kodlamaio.hmrs.core.adapters.concretes.EmailSenderAdapter;
import kodlamaio.hmrs.core.utilities.imageServices.abstracts.ImageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserActivationDao;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.Role;
import kodlamaio.hmrs.entities.dtos.EmployerDto;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserActivationDao userActivationDao;
	private ValidationService<Employer> validationService;
	private ActivationAdapter activationAdapter;
	private EmailSenderAdapter emailSenderAdapter;
	private ImageService imageService;
	private RoleService roleService;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserActivationDao userActivationDao,
			ValidationService<Employer> validationService, ActivationAdapter activationAdapter,
			EmailSenderAdapter emailSenderAdapter, ImageService imageService, RoleService roleService,
			ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.userActivationDao = userActivationDao;
		this.validationService = validationService;
		this.activationAdapter = activationAdapter;
		this.emailSenderAdapter = emailSenderAdapter;
		this.imageService = imageService;
		this.roleService = roleService;
		this.modelMapper = modelMapper;
	}

	
	

   

	

	@Override
	public DataResult<Page<Employer>> getAll(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<Employer>>(employerDao.findAll(pageable),"Veri çekme işlemi başarılı!");
	}

	@Override
	public DataResult<Employer> get(int id) {
		
		if (id==0)
			return new ErrorDataResult<Employer>(null,"Id girilmedi.");
				
		return new SuccessDataResult<Employer>(employerDao.getOne(id),"Veri çekme işlemi başarılı!");

		
	}

	@Override
	public Result addOrUpdate(EmployerDto userDto) {
		//Mapping
		Employer user = modelMapper.map(userDto, Employer.class);
		
		
		
		//User isActivated field sets to false
		user.setActivated(false);
		
		//Sets a new user activation codes and sends email.
		this.userActivationDao.save(activationAdapter.generateActivationCode());
		this.emailSenderAdapter.sendEmail(activationAdapter.getActivationCode());
		
		if (!this.employerDao.existsById(user.getId()) && user.getId()>0) {
			return new ErrorResult("Kullanıcı bulunamadı.");
		}
		//If user exists
		if (employerDao.existsById(user.getId())&& user.getId()>0) {
			Employer updatedUser = employerDao.findById(user.getId()).get();
			 //If user did not update his/her own account password
			if (user.getPassword()==null && user.getRepassword()==null) {
				user.setPassword(updatedUser.getPassword()); 
				user.setRepassword(updatedUser.getRepassword());
			}
					updatedUser.setUpdatedData(user);
					
					employerDao.save(updatedUser);
					return new SuccessResult(String.format("%s şirketi başarıyla güncellendi. Aktivasyon işlemi için lütfen bekleyin.", user.getCompanyName()));
				}
		//Adds user a role
				Role role = roleService.getByName("Employer").getData();
				user.setRole(role);
		//User validation
		if (!validationService.validateUser(user).isSuccess())
				return new ErrorResult(validationService.validateUser(user).getMessage()) ;
		
		//Saves user
		employerDao.save(user);
		return new SuccessResult(String.format("%s şirketi başarıyla eklendi. Aktivasyon işlemi için lütfen bekleyin.", user.getCompanyName()));
	}

	@Override
	public Result saveImage(MultipartFile file, int userId) {
		
		//Gets Employer
        Employer employer = employerDao.getOne(userId);
        
        //Sets image name and path for cloudinary  
        
        String imageName ="/company-pictures/"+ employer.getCompanyName() +"_"+file.getName(); 
        
        //Uploads image to cloudinary   
        Map<?, String> uploader = (Map<?, String>)imageService.save(file,imageName).getData();
        
        //Saves image url to database.
        String imageUrl= uploader.get("url");
        employer.setCompanyPicture(imageUrl);
        employerDao.save(employer);
        
        return new SuccessResult("Kayıt Başarılı");
	}



	@Override
	public Result changeEmployerActivation(int userId) {
		
		if(!employerDao.findById(userId).isPresent())
			return new ErrorResult("Kullanıcı bulunamadı.");
		
		Employer employer = employerDao.getOne(userId);
		if (!Objects.isNull(employer.getUpdatedData()) ) {
			Employer updatedData = employer.getUpdatedData();
			//Sets empty password
			updatedData.setPassword(employer.getPassword());
			updatedData.setRepassword(employer.getRepassword());
			//Sets role
			Role role = roleService.getByName("Employer").getData();
			updatedData.setRole(role);
			updatedData.setActivated(true);
			//Saves updated data instead of main data and deletes updated data row.
			employerDao.save(updatedData);
			return new SuccessResult("Kullanıcı onay durumu "+(updatedData.isActivated()?"'Onaylı'":"'Onay bekliyor'")+" olarak değiştirildi!");
		}
		employer.setActivated(!employer.isActivated());
		employerDao.save(employer);
		return new SuccessResult("Kullanıcı onay durumu "+(employer.isActivated()?"'Onaylı'":"'Onay bekliyor'")+" olarak değiştirildi!");
	}








}
