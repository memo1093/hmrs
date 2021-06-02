package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	private ResumeService resumeService;
	
	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) 
	{
		return resumeService.Add(resume);
	}
	@GetMapping("/getByCandidateId")
	public DataResult<List<Resume>> getByCandidateId(@RequestParam int id)
	{
		return resumeService.getByCandidateId(id);
	}
}
