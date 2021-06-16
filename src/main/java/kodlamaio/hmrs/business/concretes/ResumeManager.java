package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import kodlamaio.hmrs.entities.dtos.GraduationDto;
import kodlamaio.hmrs.entities.dtos.JobExperienceDto;
import kodlamaio.hmrs.entities.dtos.LanguageDto;
import kodlamaio.hmrs.entities.dtos.ResumeDto;
import kodlamaio.hmrs.entities.dtos.TalentDto;
import kodlamaio.hmrs.entities.dtos.WebAddressDto;

@Service
public class ResumeManager implements ResumeService{
	private ResumeDao resumeDao;
	private GraduationService graduationService;
	private JobExperienceService jobExperienceService;
	private TalentService talentService;
	private WebAddressService webAddressService;
	private LanguageService languageService;
	private ModelMapper modelMapper;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, GraduationService graduationService,
			JobExperienceService jobExperienceService, TalentService talentService, WebAddressService webAddressService,
			LanguageService languageService, ModelMapper modelMapper) {
		super();
		this.resumeDao = resumeDao;
		this.graduationService = graduationService;
		this.jobExperienceService = jobExperienceService;
		this.talentService = talentService;
		this.webAddressService = webAddressService;
		this.languageService = languageService;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(Resume resume) {
		
		
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
	public Result addGraduation(GraduationDto graduationDto) {
		
		Graduation graduation = modelMapper.map(graduationDto, Graduation.class);		
		return graduationService.add(graduation);
	}



	@Override
	public Result addJobExperience(JobExperienceDto jobExperienceDto) {
		
		JobExperience jobExperience = modelMapper.map(jobExperienceDto, JobExperience.class);
		return jobExperienceService.add(jobExperience);
	}

	@Override
	public Result addTalent(TalentDto talentDto) {
		Talent talent = modelMapper.map(talentDto, Talent.class);
		return talentService.add(talent);
		
	}


	@Override
	public Result addWebAddress(WebAddressDto webAddressDto) {
		WebAddress webAddress = modelMapper.map(webAddressDto, WebAddress.class);
		return webAddressService.add(webAddress);
	}

	@Override
	public Result addLanguage(LanguageDto languageDto) {
		Language language = modelMapper.map(languageDto, Language.class);
		return languageService.add(language);
	}





	@Override
	public Result addResume(ResumeDto resumeDto) {
		Resume resume = modelMapper.map(resumeDto, Resume.class);
		resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş kaydetme işlemi başarılı!");
	}

	@Override
	public DataResult<List<Resume>> getByTalentName(String talentName) {
		
		return new SuccessDataResult<List<Resume>>(resumeDao.getByTalents_NameContains(talentName),"Yeteneğe göre özgeçmiş listeleme başarılı!");
	}

	@Override
	public DataResult<List<Resume>> getByLanguageName(String language) {
		
		return new SuccessDataResult<List<Resume>>(resumeDao.getByLanguages_languageContains(language));
	}

	@Override
	public DataResult<List<Resume>> getByGraduationDegree(String degree) {
		
		return new SuccessDataResult<List<Resume>>(resumeDao.getByGraduations_SchoolDegreeContains(degree));
	}

	@Override
	public DataResult<List<Resume>> getByWorkedJobPosition(String position) {
		
		return new SuccessDataResult<List<Resume>>(resumeDao.getByJobExperiences_positionContains(position));
	}
	
	
	
	
}
