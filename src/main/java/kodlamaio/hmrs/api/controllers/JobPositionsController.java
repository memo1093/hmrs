package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;
import kodlamaio.hmrs.entities.dtos.JobPositionDto;

@RestController
@RequestMapping("/api/positions")
@CrossOrigin
public class JobPositionsController {
	private JobPositionService jobPositionService;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService, ModelMapper modelMapper) {
		super();
		this.jobPositionService = jobPositionService;
		this.modelMapper = modelMapper;
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
	public Result AddJobPosition(@RequestBody JobPositionDto jobPositionDto) {
		JobPosition jobPosition = modelMapper.map(jobPositionDto, JobPosition.class);
		
		return jobPositionService.add(jobPosition);
	}
	
}
