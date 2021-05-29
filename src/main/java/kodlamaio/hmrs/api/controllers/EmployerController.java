package kodlamaio.hmrs.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll() {
		
		return employerService.getAll();
	}
	@GetMapping("/get")
	public DataResult<Optional<Employer>> get(@RequestParam int id){
		return employerService.get(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employer user) {
		
		return employerService.add(user);
	}
	
}
