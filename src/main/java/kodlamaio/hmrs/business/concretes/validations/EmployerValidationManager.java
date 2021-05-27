package kodlamaio.hmrs.business.concretes.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String webAddressRegex="[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";
		Pattern webAddressPattern = Pattern.compile(webAddressRegex, Pattern.CASE_INSENSITIVE);
		Matcher webAddressMatcher = webAddressPattern.matcher(user.getEmail());
		String webAddressDomain = user.getWebAddress().substring(user.getWebAddress().indexOf(".")+1,user.getWebAddress().lastIndexOf("com")-1);
		
		
		//Controls email format and checks if is empty.
		if (user.getEmail().trim().isEmpty()) {
			return new ErrorResult("Email kısmı boş bırakılamaz.");
		}
		
		if (!emailDomain.trim().toLowerCase().equals(webAddressDomain.trim().toLowerCase())) {
			return new ErrorResult("Email adı(@ öncesi) ve İnternet adresi alan adı eşleşmemektedir");
		}
		//Controls passwords and checks if password is empty.
		if (user.getPassword().trim().isEmpty()) {
			return new ErrorResult("Şifre kısmı boş bırakılamaz.");
		}
		//Controls WebAddress format and checks if is empty.
		if (user.getWebAddress().trim().isEmpty()) {
			return new ErrorResult("İnternet adresi alanı kısmı boş bırakılamaz.");
		}
		if (!webAddressMatcher.matches()) {
			return new ErrorResult("İnternet adresi doğru girilmedi.");
		}
			
		//Controls CompanyName validation.
		if(user.getCompanyName().trim().isEmpty()) {
			return new ErrorResult("Şirket adı kısmı boş bırakılamaz.");
		}
		if (user.getCompanyName().trim().length()<2) {
			return new ErrorResult("Şirket adı kısmı eksik girildi.");
		}
		//Controls WebAddress validation.
		if(user.getWebAddress().trim().isEmpty()) {
			return new ErrorResult("Soyad kısmı boş bırakılamaz.");
		}
		if (user.getWebAddress().trim().length()<2) {
			return new ErrorResult("Soyad kısmı eksik girildi.");
		}
		
		//Controls PhoneNumber validation.
		if(user.getPhoneNumber().trim().isEmpty()||user.getPhoneNumber().length()!=10) {
			return new ErrorResult("Telefon(GSM) numarası eksik veya yanlış girildi. Telefon numarası 10 haneli olmalıdır.");
		}
		//If all validations are success, returns true and shows message.
		return new SuccessResult("Doğrulama Başarılı!");
	}

}
