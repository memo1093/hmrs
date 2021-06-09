package kodlamaio.hmrs.core.utilities.imageServices.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.EagerTransformation;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.imageServices.abstracts.ImageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;

@Service
public class CloudinaryManager implements ImageService{

	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}
	
	public Result upload(File file) throws IOException {
		
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("resource_type", "image",
			    "public_id", "hmrs/profile_pictures",
			    "eager", Arrays.asList(
			        new EagerTransformation().width(300).height(300).crop("pad"),
			    "eager_async", true,
			    "eager_notification_url", "https://localhost:8080/"+file.getName())));
		return new SuccessResult(uploadResult.get("url").toString() + "adlı url ye upload edildi!");
	};
	public DataResult<Map> getImage(String imageUrl) throws Exception{
		Map result = cloudinary.api().resource(imageUrl, ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(result); 
	}

	@Override
	public Result upload(MultipartFile multiPartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
