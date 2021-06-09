package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.JobExperience;

@RestController
@RequestMapping("api/jobExperiences")
public class JobExperiencesController {
	@Autowired
	private JobExperienceService jobExperienceService;

	@GetMapping("/getByCompanyName")
	public DataResult<List<JobExperience>> getByCompanyNameContains(@RequestParam String name) {
		return jobExperienceService.getByCompanyNameContains(name);
	}
	@GetMapping("/getByStillWorkingFalse")
	DataResult<List<JobExperience>> getByStillWorkingFalse(){
		return jobExperienceService.getByStillWorkingFalse();
	}
	@GetMapping("/getByPosition")
	DataResult<List<JobExperience>> getByPosition(@RequestParam String name){
		return jobExperienceService.getByPositionContains(name);
	}
}
