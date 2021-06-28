package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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
	public DataResult<List<JobPositionAdvertisement>> getAll(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam(required = false)String cityId)
	{	
		if (cityId.isEmpty()) {
			cityId="0";
		}
		
		return jobPositionAdvertisementService.getAll(pageNo,pageSize,Integer.parseInt(cityId));
	}
	@GetMapping("/getAllSorted")
	public DataResult<List<JobPositionAdvertisement>> getAllSorted(@RequestParam int pageNo,@RequestParam int pageSize){
		return jobPositionAdvertisementService.getAllSorted(pageNo,pageSize);
	}
	@PostMapping("/add")
	public Result add(@RequestBody @Valid JobPositionAdvertisementDto jobPositionAdvertisementDto)
	{
		
		return jobPositionAdvertisementService.add(jobPositionAdvertisementDto);		
	}
	@GetMapping("/getActiveJobs")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue(@RequestParam int pageNo,@RequestParam int pageSize)
	{
		return jobPositionAdvertisementService.getByIsStillActiveTrue(pageNo,pageSize);
	}
	@GetMapping("/getActiveJobsByDate")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate(@RequestParam int pageNo,@RequestParam int pageSize)
	{
		return jobPositionAdvertisementService.getByIsStillActiveTrueAndByDate(pageNo,pageSize);
	}
	@GetMapping("/getActiveJobsByCompanyName")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(@RequestParam int pageNo,@RequestParam int pageSize, @RequestParam String companyName)
	{
		return jobPositionAdvertisementService.getByIsStillActiveTrueAndCompanyName(pageNo,pageSize,companyName);
	}
	@GetMapping("/getById")
	public DataResult<JobPositionAdvertisement> getById(@RequestParam int id){
		return jobPositionAdvertisementService.getById(id);
	}
	@GetMapping("/getByJobPositionId")
	public DataResult<List<JobPositionAdvertisement>> getByJobPositionId(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam int id){
		return jobPositionAdvertisementService.getByJobPosition(pageNo,pageSize,id);
	}
	@GetMapping("/getByIsStillActiveAndPositionNameSorted")
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveAndPositionSorted(@RequestParam int pageNo,@RequestParam int pageSize, @RequestParam List<Integer> positionIds){
		
		return jobPositionAdvertisementService.getByIsStillActiveAndPositionIdSorted(pageNo,pageSize,positionIds);
	}
	@GetMapping("/getAllIsStillActiveByCityIdAndPositionIdIn")
	public DataResult<List<JobPositionAdvertisement>> getAllIsStillActiveByCityIdAndPositionIdIn(@RequestParam int pageNo,@RequestParam int pageSize,
			@RequestParam int cityId,@RequestParam List<Integer> ids){
		return jobPositionAdvertisementService.getAllIsStillActiveByCityIdAndPositionIdIn(pageNo,pageSize,cityId,ids);
	}
	

	
}
