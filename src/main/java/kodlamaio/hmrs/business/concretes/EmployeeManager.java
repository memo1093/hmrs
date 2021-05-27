package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.business.abstracts.validations.ValidationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.Employee;
import kodlamaio.hmrs.entities.concretes.Employer;


@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployerDao employerDao;
	private EmployeeDao employeeDao;
	private ValidationService<Employee> validationSevice;
	
	
	@Autowired
	public EmployeeManager(EmployerDao employerDao, EmployeeDao employeeDao,
			ValidationService<Employee> validationSevice) {
		super();
		this.employerDao = employerDao;
		this.employeeDao = employeeDao;
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
	public Result activateEmployer(int id) {
		if(!employerDao.findById(id).isPresent())
			return new ErrorResult("Kullanıcı bulunamadı.");
		Employer employer = employerDao.getOne(id);
		employer.setActivated(true);
		employerDao.save(employer);
		return new SuccessResult("Kullanıcı aktif edildi!");
	}

}
