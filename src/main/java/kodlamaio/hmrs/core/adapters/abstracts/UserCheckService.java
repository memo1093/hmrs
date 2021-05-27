package kodlamaio.hmrs.core.adapters.abstracts;

import kodlamaio.hmrs.entities.concretes.Candidate;

public interface UserCheckService {
	public boolean checkUser(Candidate user);
}
