package kodlamaio.hmrs.business.abstracts.validations;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.User;

public interface ValidationService<T extends User> {
	public Result validateUser(T user);
}
