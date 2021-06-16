package kodlamaio.hmrs.business.concretes.validations;


import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class ValidationManager{

	
	public Result validate(User user) {
		
		//Controls passwords if not equals.
		if (!user.getPassword().equals(user.getRepassword())) {
			return new ErrorResult("Şifre kısımları eşleşmiyor.");
		}
		return new SuccessResult();
	}

}
