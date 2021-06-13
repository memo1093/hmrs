package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPositionAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobPositionAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobPositionAdvertisementsController {
	private JobPositionAdvertisementService jobPositionAdvertisementService;
	private ModelMapper modelMapper;
	@Autowired
	public JobPositionAdvertisementsController(JobPositionAdvertisementService jobPositionAdvertisementService,
			ModelMapper modelMapper) {
		super();
		this.jobPositionAdvertisementService = jobPositionAdvertisementService;
		this.modelMapper = modelMapper;
	}
	

	@GetMapping("/getAll")
	public DataResult<List<JobPositionAdvertisement>> getAll()
	{
		return jobPositionAdvertisementService.getAll();
	}
	@GetMapping("/getAllSorted")
	public DataResult<List<JobPositionAdvertisement>> getAllSorted(){
		return jobPositionAdvertisementService.getAllSorted();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobPositionAdvertisementDto jobPositionAdvertisementDto)
	{
		JobPositionAdvertisement jobPositionAdvertisement=modelMapper.map(jobPositionAdvertisementDto, JobPositionAdvertisement.class);
		return jobPositionAdvertisementService.add(jobPositionAdvertisement);
		
	}
	@GetMapping("/getActiveJobs")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue()
	{
		return jobPositionAdvertisementService.getByIsStillActiveTrue();
	}
	@GetMapping("/getActiveJobsByDate")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate()
	{
		return jobPositionAdvertisementService.getByIsStillActiveTrueAndByDate();
	}
	@GetMapping("/getActiveJobsByCompanyName")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(@RequestParam String companyName)
	{
		return jobPositionAdvertisementService.getByIsStillActiveTrueAndCompanyName(companyName);
	}
	@GetMapping("/getById")
	public DataResult<JobPositionAdvertisement> getById(@RequestParam int id){
		return jobPositionAdvertisementService.getById(id);
	}
	
	

	
}
