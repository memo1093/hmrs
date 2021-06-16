package kodlamaio.hmrs.business.abstracts;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.dtos.CandidateDto;


public interface CandidateService{
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> get(int id);
	Result add(CandidateDto userDto);
	Result saveImage(MultipartFile file,int candidateId);
}
