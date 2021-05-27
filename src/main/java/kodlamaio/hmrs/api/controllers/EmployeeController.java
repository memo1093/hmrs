package kodlamaio.hmrs.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {
		
		return employeeService.getAll();
	}
	@GetMapping("/get")
	public DataResult<Optional<Employee>> get(@RequestParam int id){
		return employeeService.get(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employee user) {
		
		return employeeService.add(user);
	}
	@PostMapping("/activate")
	public Result activateEmployer(@RequestParam int id) {
		return employeeService.activateEmployer(id);
	}

}
