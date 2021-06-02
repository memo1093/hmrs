package kodlamaio.hmrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.imageServices.abstracts.ImageService;
import kodlamaio.hmrs.core.utilities.imageServices.concretes.CloudinaryManager;

@Configuration
public class CloudinaryConfig {
	@Bean
	public ImageService imageService() {
		return new CloudinaryManager(cloudinary());
	}

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dkox1pdhr", 
				"api_key", "136596742569174", 
				"api_secret","-0O-iGpSvpBUUikIEAuHbIvJaW0"));
	}
}
