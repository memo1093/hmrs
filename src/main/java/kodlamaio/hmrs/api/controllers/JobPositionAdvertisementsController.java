package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.validation.Valid;

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
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobPositionAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobPositionAdvertisementsController extends ValidationHandler {
	private JobPositionAdvertisementService jobPositionAdvertisementService;
	
	@Autowired
	public JobPositionAdvertisementsController(JobPositionAdvertisementService jobPositionAdvertisementService
			) {
		super();
		this.jobPositionAdvertisementService = jobPositionAdvertisementService;
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
	public Result add(@RequestBody @Valid JobPositionAdvertisementDto jobPositionAdvertisementDto)
	{
		
		return jobPositionAdvertisementService.add(jobPositionAdvertisementDto);		
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
	@GetMapping("/getByJobPositionId")
	public DataResult<List<JobPositionAdvertisement>> getByJobPositionId(int id){
		return jobPositionAdvertisementService.getByJobPosition(id);
	}
	

	
}
