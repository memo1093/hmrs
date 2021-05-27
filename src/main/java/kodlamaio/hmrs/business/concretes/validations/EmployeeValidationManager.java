package kodlamaio.hmrs.business.concretes.validations;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.Employee;

@Service
public class EmployeeValidationManager extends ValidationManager implements ValidationService<Employee>{

	@Override
	public Result validateUser(Employee user) {
		if (!validate(user).isSuccess()) {
			return validate(user);
		}
		//Controls FirstName validation.
		if(user.getFirstName().trim().isEmpty()) {
			return new ErrorResult("Ad kısmı boş bırakılamaz.");
		}
		if (user.getFirstName().trim().length()<2) {
			return new ErrorResult("Ad kısmı eksik girildi.");
		}
		//Controls LastName validation.
		if(user.getLastName().trim().isEmpty()) {
			return new ErrorResult("Soyad kısmı boş bırakılamaz.");
		}
		if (user.getLastName().length()<2) {
			return new ErrorResult("Soyad kısmı eksik girildi.");
		}
		return new SuccessResult("Kullanıcı doğrulama başarılı!");
	}

}
