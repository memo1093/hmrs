package kodlamaio.hmrs.core.utilities.imageServices.concretes;


import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.imageServices.abstracts.ImageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;


@Service
public class CloudinaryManager implements ImageService{

	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}
	

	@Override
	public DataResult<?> save(MultipartFile file,String filePath) {
		
		
		try{
			
            Map cloudinaryUploader = cloudinary.uploader()
                    .upload(file.getBytes()
            ,ObjectUtils.asMap("public_id", "hmrs"+filePath,
            					"overwrite","true"));
         
            //Checks file extension
            
            return new SuccessDataResult<Map>(cloudinaryUploader);
        } 
		catch (IOException e){
           e.printStackTrace();
           return new ErrorDataResult<Map>(null,e.getMessage());
        }
        
		
	}


	
	
	
}
