package kodlamaio.hmrs.core.utilities.imageServices.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;


public interface ImageService {
	
	DataResult<?> save(MultipartFile file,String fileName);
	
}
