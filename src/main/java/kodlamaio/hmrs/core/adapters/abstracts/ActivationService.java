package kodlamaio.hmrs.core.adapters.abstracts;

import kodlamaio.hmrs.entities.concretes.UserActivation;

public interface ActivationService {
	public UserActivation generateActivationCode();
	public String getActivationCode();
}
