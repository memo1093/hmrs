package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobExperience;

public interface JobExperienceService {
	
	
	DataResult<List<JobExperience>> getByCompanyNameContains(String name);
	DataResult<List<JobExperience>> getByStillWorkingFalse();
	DataResult<List<JobExperience>> getByPositionContains(String name);
	Result add(JobExperience jobExperience);
}
