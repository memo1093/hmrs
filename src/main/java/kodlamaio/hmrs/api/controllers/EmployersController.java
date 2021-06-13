package kodlamaio.hmrs.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployerDto;


@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	private EmployerService employerService;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployersController(EmployerService employerService, ModelMapper modelMapper) {
		super();
		this.employerService = employerService;
		this.modelMapper = modelMapper;
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
	public Result add(@RequestBody @Valid EmployerDto employerDto) {
		Employer user = modelMapper.map(employerDto, Employer.class);
		return employerService.add(user);
	}
	@PostMapping("/addCompanyProfilePicture")
	public Result addCompanyProfilePicture(@RequestBody MultipartFile file,@RequestParam int userId) {
		
		return employerService.saveImage(file,userId);
	}
	
}
