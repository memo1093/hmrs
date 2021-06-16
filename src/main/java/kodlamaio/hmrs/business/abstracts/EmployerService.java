package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployerDto;

public interface EmployerService{
	DataResult<List<Employer>> getAll();
	DataResult<Employer> get(int id);
	Result add(EmployerDto user);
	Result saveImage(MultipartFile file,int userId);
	Result changeEmployerActivation(int userId);
}
