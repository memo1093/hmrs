package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Role;

public interface RoleService {
	DataResult<List<Role>> getAll();
	DataResult<Role> getById(int id);
	DataResult<Role> getByName(String name);
	
	DataResult<Role> addOrUpdate(Role role);
	
}
