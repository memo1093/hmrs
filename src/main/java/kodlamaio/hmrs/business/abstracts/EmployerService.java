package kodlamaio.hmrs.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployerDto;

public interface EmployerService{
	DataResult<Page<Employer>> getAll(int pageNo,int pageSize);
	DataResult<Employer> get(int id);
	Result addOrUpdate(EmployerDto user);
	Result saveImage(MultipartFile file,int userId);
	Result changeEmployerActivation(int userId);
}
