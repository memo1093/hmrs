package kodlamaio.hmrs.business.concretes.validations;
import org.springframework.stereotype.Service;
import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
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
		
		
		String webAddressDomain = user.getWebAddress().substring(user.getWebAddress().indexOf(".")+1,user.getWebAddress().lastIndexOf("com")-1);
		String webAddressDomain2 = user.getWebAddress().substring(user.getWebAddress().indexOf("https://")+1,user.getWebAddress().lastIndexOf("com")-1);
		String webAddressDomain3 = user.getWebAddress().substring(user.getWebAddress().indexOf("http://")+1,user.getWebAddress().lastIndexOf("com")-1);
		String webAddressDomain4 = user.getWebAddress().substring(user.getWebAddress().indexOf(".")+1,user.getWebAddress().lastIndexOf("net")-1);
		String webAddressDomain5 = user.getWebAddress().substring(user.getWebAddress().indexOf("https://")+1,user.getWebAddress().lastIndexOf("net")-1);
		String webAddressDomain6 = user.getWebAddress().substring(user.getWebAddress().indexOf("http://")+1,user.getWebAddress().lastIndexOf("net")-1);
		
		
				
		if(emailDomain.trim().toLowerCase().equals(webAddressDomain.trim().toLowerCase()) ||
		emailDomain.trim().toLowerCase().equals(webAddressDomain2.trim().toLowerCase()) ||
		emailDomain.trim().toLowerCase().equals(webAddressDomain3.trim().toLowerCase())	||
		emailDomain.trim().toLowerCase().equals(webAddressDomain4.trim().toLowerCase())	||
		emailDomain.trim().toLowerCase().equals(webAddressDomain5.trim().toLowerCase())	||
		emailDomain.trim().toLowerCase().equals(webAddressDomain6.trim().toLowerCase())){
			return new SuccessResult("Doğrulama Başarılı!");
		}
		
		//If all validations are not valid, returns false and shows message.
		return new SuccessResult("Email adı(@ öncesi) ve İnternet adresi alan adı eşleşmemektedir");
		
	}

}
