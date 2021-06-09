package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/positions")
public class JobPositionsController {
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> JobPositions() {
		return jobPositionService.getAll();
	}
	@GetMapping("/get")
	public Result JobPosition(int id) {
		return jobPositionService.get(id);
	}
	@PostMapping("/add")
	public Result AddJobPosition(@RequestBody JobPosition jobPosition) {
		return jobPositionService.add(jobPosition);
	}
	
}
