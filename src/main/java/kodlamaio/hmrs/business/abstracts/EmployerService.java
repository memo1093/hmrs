package kodlamaio.hmrs.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerService extends UserService<Employer>{
	Result saveImage(MultipartFile file,int userId);
	Result changeEmployerActivation(int userId);
}
