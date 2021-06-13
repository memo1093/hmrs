package kodlamaio.hmrs.business.abstracts;




import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employee;


public interface EmployeeService extends UserService<Employee>{
	Result changeEmployerActivation(int employerId);
	Result changeJobAdvertisementActivation(int employerId);

}
