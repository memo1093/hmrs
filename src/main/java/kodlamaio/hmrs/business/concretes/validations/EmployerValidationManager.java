package kodlamaio.hmrs.business.concretes.validations;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerValidationManager extends ValidationManager implements ValidationService<Employer>{

	@Override
	public Result validateUser(Employer user) {
		
	
		if (!validate(user).isSuccess()) {
			return validate(user);
		}
		
		
		String emailDomain = user.getEmail().substring(0, user.getEmail().indexOf("@"));
		URI uri;
		try {
			uri = new URI(user.getWebAddress());
			String uriHost= uri.getHost();
			String uriHostName =uriHost.startsWith("www")? uriHost.substring(4,uriHost.lastIndexOf(".")):uriHost.substring(0,uriHost.lastIndexOf("."));
			
			if (uriHostName.equals(emailDomain)) {
				return new SuccessResult("Doğrulama Başarılı!");
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		
		//If all validations are not valid, returns false and shows message.
		return new ErrorResult("Email adı(@ öncesi) ve İnternet adresi alan adı eşleşmemektedir");
		
	}

}
