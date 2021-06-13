package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.JobPositionAdvertisementService;
import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hmrs.entities.concretes.Employee;



@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;	
	private EmployerService employerService;
	private JobPositionAdvertisementService jobPositionAdvertisementService;
	private ValidationService<Employee> validationSevice;
	
	

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, EmployerService employerService,
			JobPositionAdvertisementService jobPositionAdvertisementService,
			ValidationService<Employee> validationSevice) {
		super();
		this.employeeDao = employeeDao;
		this.employerService = employerService;
		this.jobPositionAdvertisementService = jobPositionAdvertisementService;
		this.validationSevice = validationSevice;
	}

	
	

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(),"Veri çekme işlemi başarılı!");
	}

	@Override
	public DataResult<Optional<Employee>> get(int id) {
		
		return new SuccessDataResult<Optional<Employee>>(employeeDao.findById(id),"Veri çekme işlemi başarılı!");
	}

	@Override
	public Result add(Employee user) {
		//User validation
		if(!validationSevice.validateUser(user).isSuccess())
			return validationSevice.validateUser(user);
		//If user exists
		for (Employee employee : employeeDao.findAll()) {
			if(employee.equals(user))
				return new ErrorResult("Kullanıcı zaten mevcut!");
		}
		//Save user
		employeeDao.save(user);
		return new SuccessResult(String.format("%s %s adlı admin kullanıcı ekleme işlemi başarılı!",user.getFirstName(),user.getLastName()));
	}

	@Override
	public Result changeEmployerActivation(int employerId) {
		return employerService.changeEmployerActivation(employerId);
	}

	@Override
	public Result changeJobAdvertisementActivation(int jobAdvertisementId) {
		
		
		return jobPositionAdvertisementService.changeApproveJobPositionAdvetisement(jobAdvertisementId);
	}

}
