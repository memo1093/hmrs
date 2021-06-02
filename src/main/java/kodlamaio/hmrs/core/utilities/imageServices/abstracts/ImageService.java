package kodlamaio.hmrs.core.utilities.imageServices.abstracts;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface ImageService {
	public Result upload(File file) throws IOException;
	public DataResult<Map> getImage(String imageUrl) throws Exception;
}
