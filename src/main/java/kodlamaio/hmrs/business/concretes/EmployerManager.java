package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.EmployerService;
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


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserActivationDao userActivationDao;
	private ValidationService<Employer> validationService;
	private ActivationAdapter activationAdapter;
	private EmailSenderAdapter emailSenderAdapter;
	private ImageService imageService;
	
	

	

	
	@Autowired
    public EmployerManager(EmployerDao employerDao, UserActivationDao userActivationDao,
			ValidationService<Employer> validationService, ActivationAdapter activationAdapter,
			EmailSenderAdapter emailSenderAdapter, ImageService imageService) {
		super();
		this.employerDao = employerDao;
		this.userActivationDao = userActivationDao;
		this.validationService = validationService;
		this.activationAdapter = activationAdapter;
		this.emailSenderAdapter = emailSenderAdapter;
		this.imageService = imageService;
	}

	

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Veri çekme işlemi başarılı!");
	}

	@Override
	public DataResult<Optional<Employer>> get(int id) {
		Optional<Employer> data = employerDao.findById(id);
		if (id==0)
			return new ErrorDataResult<Optional<Employer>>(null,"Id girilmedi.");
		if (!data.isPresent())
			return new ErrorDataResult<Optional<Employer>>(null,"Kullanıcı bulunamadı.");
		
		return new SuccessDataResult<Optional<Employer>>(data,"Veri çekme işlemi başarılı!");

		
	}

	@Override
	public Result add(Employer user) {
		//User validation
		if (validationService.validateUser(user).isSuccess()==false)
			return validationService.validateUser(user);
		//User isActivated field sets to false
		user.setActivated(false);
		//Sets a new user activation codes and sends email.
		this.userActivationDao.save(activationAdapter.generateActivationCode());
		this.emailSenderAdapter.sendEmail(activationAdapter.getActivationCode());
		//Saves user
		employerDao.save(user);
		return new SuccessResult(String.format("%s şirketi başarıyla sisteme kaydedildi. Aktivasyon işlemi için lütfen bekleyin.", user.getCompanyName()));
	}

	@Override
	public Result saveImage(MultipartFile file, int userId) {
		//Gets Employer
        Employer employer = employerDao.getOne(userId);
      //Sets image name and path for cloudinary  (if image name exist in cloudinary, it will overwrite)
        String imageName ="/company-pictures/"+ employer.getCompanyName() +"_"+userId; 
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
		
		employer.setActivated(!employer.isActivated());
		employerDao.save(employer);
		return new SuccessResult("Kullanıcı onay durumu "+(employer.isActivated()?"'Onaylı'":"'Onay bekliyor'")+" olarak değiştirildi!");
	}





}
