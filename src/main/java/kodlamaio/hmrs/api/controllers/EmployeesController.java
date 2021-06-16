package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController extends ValidationHandler{
	private EmployeeService employeeService;

	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {
		
		return employeeService.getAll();
	}
	@GetMapping("/get")
	public DataResult<Employee> get(@RequestParam int id){
		return employeeService.get(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody @Valid Employee user) {
		
		return employeeService.add(user);
	}
	@PostMapping("/changeActivation")
	public Result changeActivation(@RequestParam int employerId) {
		return employeeService.changeEmployerActivation(employerId);
	}
	@PostMapping("/changeJobAdvertisementActivation")
	public Result changeJobAdvertisementActivation(int jobAdvertisementId) {
		return employeeService.changeJobAdvertisementActivation(jobAdvertisementId);
	}

}
