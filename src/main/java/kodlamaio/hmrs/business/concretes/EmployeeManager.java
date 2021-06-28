package kodlamaio.hmrs.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.JobPositionAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hmrs.entities.concretes.Employee;
import kodlamaio.hmrs.entities.dtos.EmployeeDto;



@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;	
	private EmployerService employerService;
	private JobPositionAdvertisementService jobPositionAdvertisementService;
	
	private ModelMapper modelMapper;

	

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, EmployerService employerService,
			JobPositionAdvertisementService jobPositionAdvertisementService, ModelMapper modelMapper) {
		super();
		this.employeeDao = employeeDao;
		this.employerService = employerService;
		this.jobPositionAdvertisementService = jobPositionAdvertisementService;
		this.modelMapper = modelMapper;
	}

	

	@Override
	public DataResult<Page<Employee>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<Employee>>(employeeDao.findAll(pageable),"Veri çekme işlemi başarılı!");
	}

	@Override
	public DataResult<Employee> get(int id) {
		
		return new SuccessDataResult<Employee>(employeeDao.getOne(id),"Veri çekme işlemi başarılı!");
	}

	@Override
	public Result addOrUpdate(EmployeeDto userDto) {
		
		Employee user = modelMapper.map(userDto,Employee.class);
	
		//If user is not exists and more than 0
		if (!employeeDao.existsById(user.getId()) && user.getId()>0) {
			return new ErrorResult("Kullanıcı bulunamadı"); 
		}
		//Save user
		employeeDao.save(user);
		return new SuccessResult(employeeDao.existsById(user.getId())
				?String.format("%s %s adlı admin kullanıcı güncelleme işlemi başarılı!",user.getFirstName(),user.getLastName()) 
						:String.format("%s %s adlı admin kullanıcı ekleme işlemi başarılı!",user.getFirstName(),user.getLastName()));
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
