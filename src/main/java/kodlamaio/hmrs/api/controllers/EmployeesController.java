package kodlamaio.hmrs.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.Employee;
import kodlamaio.hmrs.entities.concretes.User;
import kodlamaio.hmrs.entities.dtos.EmployeeDto;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController extends ValidationHandler{
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/getAll")
	public DataResult<Page<Employee>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
		
		return employeeService.getAll(pageNo,pageSize);
	}
	@GetMapping("/get")
	public DataResult<Employee> get(@RequestParam int id){
		return employeeService.get(id);
	}
	@GetMapping("/getAllUsers")
	public DataResult<Page<User>> getAllUsers(@RequestParam int pageNo, @RequestParam int pageSize){
		return employeeService.getAllUsers(pageNo, pageSize);
	}
	@PostMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody @Valid EmployeeDto userDto) {
		
		return employeeService.addOrUpdate(userDto);
	}
	@PostMapping("/changeActivation")
	public Result changeActivation(@RequestParam int employerId) {
		return employeeService.changeEmployerActivation(employerId);
	}
	@PostMapping("/changeJobAdvertisementActivation")
	public Result changeJobAdvertisementActivation(int jobAdvertisementId) {
		return employeeService.changeJobAdvertisementActivation(jobAdvertisementId);
	}
	@PostMapping("/setRoleToUser")
	DataResult<User> setRoleToUser(@RequestParam int userId,@RequestParam String roleName){
		return employeeService.setRoleToUser(userId, roleName);
	}
	

}
