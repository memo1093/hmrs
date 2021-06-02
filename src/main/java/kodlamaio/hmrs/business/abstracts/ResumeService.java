package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Resume;

public interface ResumeService {
	public Result Add(Resume resume);
	public DataResult<List<Resume>> getByCandidateId(int id);
	
}
