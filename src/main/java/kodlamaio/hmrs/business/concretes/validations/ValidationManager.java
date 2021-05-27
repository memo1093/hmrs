package kodlamaio.hmrs.business.concretes.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class ValidationManager{

	
	public Result validate(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		//Controls email format and checks if is empty.
		if (user.getEmail().trim().isEmpty()) {
			return new ErrorResult("Email kısmı boş bırakılamaz.");
		}
		if (!matcher.matches()) {
			return new ErrorResult("Email doğru girilmedi.");
		}
		//Controls passwords and checks if password is empty.
		if (user.getPassword().trim().isEmpty()) {
			return new ErrorResult("Şifre kısmı boş bırakılamaz.");
		}
		if (user.getRepassword().trim().isEmpty()) {
			return new ErrorResult("Şifre kısmı boş bırakılamaz.");
		}
		if (user.getRepassword().trim().isEmpty()) {
			return new ErrorResult("Şifre tekrarı kısmı boş bırakılamaz.");
		}
		if (!user.getPassword().equals(user.getRepassword())) {
			return new ErrorResult("Şifre kısımları eşleşmiyor.");
		}
		return new SuccessResult();
	}

}
