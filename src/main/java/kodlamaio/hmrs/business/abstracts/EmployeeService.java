package kodlamaio.hmrs.business.abstracts;




import org.springframework.data.domain.Page;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employee;
import kodlamaio.hmrs.entities.concretes.User;
import kodlamaio.hmrs.entities.dtos.EmployeeDto;


public interface EmployeeService{
	DataResult<Page<Employee>> getAll(int pageNo, int pageSize);
	DataResult<Employee> get(int id);
	DataResult<User> setRoleToUser(int userId,String roleName);
	DataResult<Page<User>> getAllUsers(int pageNo, int pageSize);
	
	
	Result addOrUpdate(EmployeeDto userDto);
	Result changeEmployerActivation(int employerId);
	Result changeJobAdvertisementActivation(int employerId);
	

}
