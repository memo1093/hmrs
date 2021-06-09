package kodlamaio.hmrs.core.utilities.imageServices.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface ImageService {
	public Result upload(MultipartFile multiPartFile) throws IOException;
	public DataResult<Map> getImage(String imageUrl) throws Exception;
}
