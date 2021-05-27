package kodlamaio.hmrs.business.concretes.validations;


import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.Candidate;

@Service
public class CandidateValidationManager extends ValidationManager implements ValidationService<Candidate>{
	
	
	public Result validateUser(Candidate user) {
		
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
		//Controls BirthDate validation.
		if(user.getBirthDate().getYear()==0||user.getBirthDate().getYear()<=1900) {
			return new ErrorResult("Doğum yılı bilgisi yanlış yada eksik girildi.");
		}
		//Controls IdentityNumber validation.
		if(user.getIdentityNumber().trim().isEmpty()||user.getIdentityNumber().length()!=11) {
			return new ErrorResult("Kimlik numarası eksik veya yanlış girildi.");
		}
		//If all validations are success, returns true and shows message.
		return new SuccessResult("Doğrulama Başarılı!");
		
	}

}
