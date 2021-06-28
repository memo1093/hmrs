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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployerDto;


@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController extends ValidationHandler {
	private EmployerService employerService;
		
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
		
	}
	@GetMapping("/getAll")
	public DataResult<Page<Employer>> getAll(@RequestParam int pageNo,@RequestParam int pageSize) {
		
		return employerService.getAll(pageNo,pageSize);
	}
	@GetMapping("/get")
	public DataResult<Employer> get(@RequestParam int id){
		return employerService.get(id);
	}
	@PostMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody @Valid EmployerDto employerDto) {
		
		return employerService.addOrUpdate(employerDto);
	}
	@PostMapping("/addCompanyProfilePicture")
	public Result addCompanyProfilePicture(@RequestBody MultipartFile file,@RequestParam int userId) {
		
		return employerService.saveImage(file,userId);
	}
	
}
