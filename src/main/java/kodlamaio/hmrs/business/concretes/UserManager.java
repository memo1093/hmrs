package kodlamaio.hmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.Role;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class UserManager implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public DataResult<User> getById(int userId) {
		
		return new SuccessDataResult<User>(userDao.findById(userId).get());
	}

	@Override
	public Result addOrUpdate(User user) {
		userDao.save(user);
		return new SuccessResult("Ekleme/Güncelleme işlemi başarılı!");
	}

	@Override
	public DataResult<Page<User>> getAll(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<User>>(userDao.findAll(pageable),"Tüm kullanıcılar başarıyla getirildi!");
	}

	@Override
	public DataResult<String> getRoleNameById(int id) {
		
		return new SuccessDataResult<String>(userDao.getRoleByUserId(id), "Rol adı getirme işlemi başarılı!");
	}

}
