package kodlamaio.hmrs.business.abstracts;


import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Graduation;
import kodlamaio.hmrs.entities.concretes.JobExperience;
import kodlamaio.hmrs.entities.concretes.Language;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.concretes.Talent;
import kodlamaio.hmrs.entities.concretes.WebAddress;


public interface ResumeService {
	Result add(Resume resume);
	DataResult<List<Resume>> getAll();
	DataResult<Resume> getById(int id);
	DataResult<List<Resume>> getByCandidateId(int id);
	Result addGraduation(Graduation graduation);
	Result addJobExperience(JobExperience jobExperience);
	Result addTalent(Talent talent);
	Result addWebAddress(WebAddress webAddress);
	Result addLanguage(Language language);
	
	
	
	
}
