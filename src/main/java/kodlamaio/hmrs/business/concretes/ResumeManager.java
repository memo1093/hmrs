package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.GraduationService;
import kodlamaio.hmrs.business.abstracts.JobExperienceService;
import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.business.abstracts.TalentService;
import kodlamaio.hmrs.business.abstracts.WebAddressService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeDao;
import kodlamaio.hmrs.entities.concretes.Graduation;
import kodlamaio.hmrs.entities.concretes.JobExperience;
import kodlamaio.hmrs.entities.concretes.Language;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.concretes.Talent;
import kodlamaio.hmrs.entities.concretes.WebAddress;

@Service
public class ResumeManager implements ResumeService{
	private ResumeDao resumeDao;
	private GraduationService graduationService;
	private JobExperienceService jobExperienceService;
	private TalentService talentService;
	private WebAddressService webAddressService;
	private LanguageService languageService;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, GraduationService graduationService,
			JobExperienceService jobExperienceService, TalentService talentService, WebAddressService webAddressService,
			LanguageService languageService) {
		super();
		this.resumeDao = resumeDao;
		this.graduationService = graduationService;
		this.jobExperienceService = jobExperienceService;
		this.talentService = talentService;
		this.webAddressService = webAddressService;
		this.languageService = languageService;
	}

	

	@Override
	public Result add(Resume resume) {
		
		resume.getGraduations().forEach(graduation->graduation.setResume(resume));
		resume.getLanguages().forEach(language->language.setResume(resume));
		resume.getTalents().forEach(talents->talents.setResume(resume));
		resume.getWebAddresses().forEach(webAddress->webAddress.setResume(resume));
		resumeDao.save(resume);
		return new SuccessResult("Veri kaydetme işlemi başarılı!");
	}

	@Override
	public DataResult<List<Resume>> getAll() {

		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(),"Özgeçmiş listesi getirme işlemi başarılı!");
	}

	@Override
	public DataResult<Resume> getById(int id) {
		
		return new SuccessDataResult<Resume>(resumeDao.getOne(id),"Özgeçmiş getirme başarılı!");
	}

	@Override
	public DataResult<List<Resume>> getByCandidateId(int id) {
		
		return new SuccessDataResult<List<Resume>>(resumeDao.getByCandidate_Id(id),"Özgeçmiş listesi getirme işlemi başarılı!");
	}

	@Override
	public Result addGraduation(Graduation graduation) {
		
				
		return graduationService.add(graduation);
	}



	@Override
	public Result addJobExperience(JobExperience jobExperience) {
		
		return jobExperienceService.add(jobExperience);
	}

	@Override
	public Result addTalent(Talent talent) {
		
		return talentService.add(talent);
		
	}


	@Override
	public Result addWebAddress(WebAddress webAddress) {
		
		return webAddressService.add(webAddress);
	}

	@Override
	public Result addLanguage(Language language) {
		
		return languageService.add(language);
	}
	
	
	
	
}
