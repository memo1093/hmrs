package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobPositionAdvertisementController {
	private JobPositionAdvertisementService jobPositionAdvertisementService;
	@Autowired
	public JobPositionAdvertisementController(JobPositionAdvertisementService jobPositionAdvertisementService) {
		super();
		this.jobPositionAdvertisementService = jobPositionAdvertisementService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobPositionAdvertisement>> getAll()
	{
		return jobPositionAdvertisementService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobPositionAdvertisement jobPositionAdvertisement)
	{
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
	
}
