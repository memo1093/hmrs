package kodlamaio.hmrs.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface UserService<T> {
	DataResult<List<T>> getAll();
	DataResult<Optional<T>> get(int id);
	Result add(T user);
	
	
	
}
