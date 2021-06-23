package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;
import kodlamaio.hmrs.entities.concretes.JobTime;
import kodlamaio.hmrs.entities.concretes.JobType;
import kodlamaio.hmrs.entities.dtos.JobPositionDto;

public interface JobPositionService{
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobType>> getAllJobTypes();
	DataResult<List<JobTime>> getAllJobTimes();
	DataResult<JobPosition> get(int id);
	Result add(JobPositionDto jobPositionDto);
}
