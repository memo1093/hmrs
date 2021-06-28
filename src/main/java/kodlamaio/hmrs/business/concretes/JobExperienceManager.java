package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hmrs.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getByCompanyNameContains(String name) {
		
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByCompanyNameContains(name),"İş yeri adına göre çalışanlar listesi getirilme işlemi başarılı!");
	}

	@Override
	public DataResult<List<JobExperience>> getByStillWorkingFalse() {
		
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByStillWorkingFalse(), "İş arayanlardan şuanda çalışmayanların listesini getirme işlemi başarılı!");
	}

	@Override
	public DataResult<List<JobExperience>> getByPositionContains(String name) {
		
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByPositionContains(name), "İlgili pozisyona ait çalışanlar listesini getirme işlemi başarılı!");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		
		jobExperienceDao.save(jobExperience);
		return new SuccessResult("Tecrübe bilgisi kayıt işlemi başarılı!");
	}

	@Override
	public DataResult<List<JobExperience>> getByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByResume_Id(resumeId));
	}

}
