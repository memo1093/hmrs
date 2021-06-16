package kodlamaio.hmrs.business.abstracts;




import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employee;


public interface EmployeeService{
	DataResult<List<Employee>> getAll();
	DataResult<Employee> get(int id);
	Result add(Employee user);
	Result changeEmployerActivation(int employerId);
	Result changeJobAdvertisementActivation(int employerId);

}
