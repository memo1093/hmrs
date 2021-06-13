package kodlamaio.hmrs.business.abstracts;


import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;


public interface CandidateService extends UserService<Candidate>{
	Result saveImage(MultipartFile file,int candidateId);
}
