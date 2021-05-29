package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.adapters.concretes.ActivationAdapter;
import kodlamaio.hmrs.core.adapters.concretes.EmailSenderAdapter;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
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
	
	
	

	

	
    @Autowired
	public EmployerManager(EmployerDao employerDao, UserActivationDao userActivationDao,
			ValidationService<Employer> validationService, ActivationAdapter activationAdapter,
			EmailSenderAdapter emailSenderAdapter) {
		super();
		this.employerDao = employerDao;
		this.userActivationDao = userActivationDao;
		
		this.validationService = validationService;
		this.activationAdapter = activationAdapter;
		this.emailSenderAdapter = emailSenderAdapter;
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





}
