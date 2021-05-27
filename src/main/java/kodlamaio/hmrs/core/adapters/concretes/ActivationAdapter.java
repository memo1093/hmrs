package kodlamaio.hmrs.core.adapters.concretes;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.ActivationService;
import kodlamaio.hmrs.entities.concretes.UserActivation;

@Service
public class ActivationAdapter implements ActivationService{

	UUID uuid=UUID.randomUUID();
	@Override
	public UserActivation generateActivationCode() {
		UserActivation userActivation = new UserActivation();
		
		userActivation.setActivationCode(uuid.toString());
		userActivation.setConfirmDate(LocalDate.now());
		return userActivation;
	}

	@Override
	public String getActivationCode() {
		
		return uuid.toString();
	}

}
