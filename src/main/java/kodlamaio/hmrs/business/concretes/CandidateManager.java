package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateService;

import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.adapters.abstracts.UserCheckService;
import kodlamaio.hmrs.core.adapters.concretes.ActivationAdapter;
import kodlamaio.hmrs.core.adapters.concretes.EmailSenderAdapter;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateDao;

import kodlamaio.hmrs.dataAccess.abstracts.UserActivationDao;
import kodlamaio.hmrs.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private UserActivationDao userActivationDao;
	private ValidationService<Candidate> validationService;
	private UserCheckService userCheckService;
	
	private ActivationAdapter activationAdapter;
	private EmailSenderAdapter emailSenderAdapter;
	
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserActivationDao userActivationDao,
			ValidationService<Candidate> validationService, UserCheckService userCheckService, ActivationAdapter activationAdapter, EmailSenderAdapter emailSenderAdapter) {
		super();
		this.candidateDao = candidateDao;
		this.userActivationDao = userActivationDao;
		this.validationService = validationService;
		this.userCheckService = userCheckService;
		this.activationAdapter = activationAdapter;
		this.emailSenderAdapter = emailSenderAdapter;
	}

	

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Veri getirme işlemi başarılı!");
		
	}

	@Override
	public DataResult<Optional<Candidate>> get(int id) {
		Optional<Candidate> data = this.candidateDao.findById(id);
		//if user could not found, sends error
		if (!data.isPresent())
			return new ErrorDataResult<Optional<Candidate>>(null,"Kullanıcı bulunamadı.");
		//Sends status with data
		return new SuccessDataResult<Optional<Candidate>>(candidateDao.findById(id),"Veri getirme işlemi başarılı!");
	}

	@Override
	public Result add(Candidate user) {
		//User validation
		if (this.validationService.validateUser(user).isSuccess()==false)
			return validationService.validateUser(user);
		//Checks if user email and identity number is exists		
		for (Candidate candidate : this.candidateDao.findAll()) {
			if (candidate.getIdentityNumber().equals(user.getIdentityNumber()) || candidate.getEmail().equals(user.getEmail()))
				return new ErrorResult("Böyle bir kullanıcı zaten mevcut.");
		}
		//Checks user identity number is real
		if (!userCheckService.checkUser(user))
			return new ErrorResult("Bu kimlik numarasına ait kullanıcı bulunamadı.");
		//Sets a new user activation codes and sends email.
		this.userActivationDao.save(activationAdapter.generateActivationCode());
		this.emailSenderAdapter.sendEmail(activationAdapter.getActivationCode());
		
		
		//Saves user
		this.candidateDao.save(user);
		return new SuccessResult(String.format("%s %s adlı kullanıcı başarıyla eklendi!",user.getFirstName(),user.getLastName()));
		
	}

	

}
