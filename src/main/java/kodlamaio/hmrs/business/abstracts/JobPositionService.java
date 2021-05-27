package kodlamaio.hmrs.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;

public interface JobPositionService{
	DataResult<List<JobPosition>> getAll();
	DataResult<Optional<JobPosition>> get(int id);
	Result add(JobPosition entity);
}
