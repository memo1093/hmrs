package kodlamaio.hmrs.business.concretes;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.adapters.abstracts.UserCheckService;
import kodlamaio.hmrs.core.adapters.concretes.ActivationAdapter;
import kodlamaio.hmrs.core.adapters.concretes.EmailSenderAdapter;
import kodlamaio.hmrs.core.utilities.imageServices.abstracts.ImageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserActivationDao;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.dtos.CandidateDto;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private UserActivationDao userActivationDao;
	private UserCheckService userCheckService;
	private ImageService imageService;
	private ModelMapper modelMapper;
	
	private ActivationAdapter activationAdapter;
	private EmailSenderAdapter emailSenderAdapter;
	
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserActivationDao userActivationDao,
			UserCheckService userCheckService, ImageService imageService, ModelMapper modelMapper,
			ActivationAdapter activationAdapter, EmailSenderAdapter emailSenderAdapter) {
		super();
		this.candidateDao = candidateDao;
		this.userActivationDao = userActivationDao;
		this.userCheckService = userCheckService;
		this.imageService = imageService;
		this.modelMapper = modelMapper;
		this.activationAdapter = activationAdapter;
		this.emailSenderAdapter = emailSenderAdapter;
	}

	@Override
	public DataResult<Page<Candidate>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<Candidate>>(this.candidateDao.findAll(pageable),"Veri getirme işlemi başarılı!");
		
	}

	@Override
	public DataResult<Candidate> get(int id) {
		
		//Sends status with data
		return new SuccessDataResult<Candidate>(this.candidateDao.getOne(id),"Veri getirme işlemi başarılı!");
	}

	@Override
	public Result addOrUpdate(CandidateDto userDto) {
		//Model mapping
		Candidate user = modelMapper.map(userDto, Candidate.class);
	
		//if candidate exist it will update the candidate.
		
		//Checks if given id is not exist in database and more than 0 returns Error
		if (!this.candidateDao.existsById(user.getId()) && user.getId()>0) {
			return new ErrorResult("Kullanıcı bulunamadı.");
		}
		
		
		//Checks user identity number is real
		if (!userCheckService.checkUser(user))
			return new ErrorResult("Bu kimlik numarasına ait kullanıcı bulunamadı.");
		
		//Sets a new user activation codes and sends email.
		this.userActivationDao.save(activationAdapter.generateActivationCode());
		this.emailSenderAdapter.sendEmail(activationAdapter.getActivationCode());
		
		
		//Saves user
		this.candidateDao.save(user);
		return new SuccessResult(this.candidateDao.existsById(user.getId())
				?String.format("%s %s adlı kullanıcı başarıyla güncellendi!",user.getFirstName(),user.getLastName())
						:String.format("%s %s adlı kullanıcı başarıyla eklendi!",user.getFirstName(),user.getLastName()));
		
	}
	@Override
	public Result saveImage(MultipartFile file, int userId) {
		
		//Gets Candidate
	    Candidate candidate = candidateDao.getOne(userId);
	    
	    //Sets image name and path for cloudinary  (if image name exist in cloudinary, it will overwrite
	    String imageName ="/profile-pictures/"+ candidate.getFirstName() +"_"+candidate.getFirstName()+"_"+userId; 
	    
	    //Uploads image to cloudinary   
	    Map<?, String> uploader = (Map<?, String>)imageService.save(file,imageName).getData();
	    
	    //Saves image url to database.
	    String imageUrl= uploader.get("url");
	    candidate.setProfilePicture(imageUrl);
	    candidateDao.save(candidate);
	        
	    return new SuccessResult("Kayıt Başarılı");
		
	}

	

}
