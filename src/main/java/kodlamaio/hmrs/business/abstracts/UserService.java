package kodlamaio.hmrs.business.abstracts;

import org.springframework.data.domain.Page;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserService {
	DataResult<User> getById(int userId);
	DataResult<Page<User>> getAll(int pageNo,int pageSize);
	Result addOrUpdate (User user);
}
