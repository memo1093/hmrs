package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.RoleService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.RoleDao;
import kodlamaio.hmrs.entities.concretes.Role;

@Service
public class RoleManager implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public DataResult<List<Role>> getAll() {
		
		return new SuccessDataResult<List<Role>>(roleDao.findAll(),"Rol listesi başarıyla getirildi!");
	}

	@Override
	public DataResult<Role> getById(int id) {
		
		return new SuccessDataResult<Role>(roleDao.getOne(id), "Id ye göre rol getirme işlemi başarılı!");
	}

	

	@Override
	public DataResult<Role> addOrUpdate(Role role) {
		
		Role savedRole = roleDao.save(role);
		return new SuccessDataResult<Role>(savedRole,"Rol başarı ile eklendi!");
	}

	@Override
	public DataResult<Role> getByName(String name) {
		
		return new SuccessDataResult<Role>(roleDao.findByNameIgnoreCase(name), null);
	}

}
