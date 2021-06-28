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
import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.dtos.GraduationDto;
import kodlamaio.hmrs.entities.dtos.JobExperienceDto;
import kodlamaio.hmrs.entities.dtos.LanguageDto;
import kodlamaio.hmrs.entities.dtos.ResumeDto;
import kodlamaio.hmrs.entities.dtos.TalentDto;
import kodlamaio.hmrs.entities.dtos.WebAddressDto;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController extends ValidationHandler {
	@Autowired
	private ResumeService resumeService;

	@PostMapping("/addResume")
	public Result addResume(@RequestBody @Valid ResumeDto resumeDto) 
	{
		
		return resumeService.addOrUpdateResume(resumeDto);
	}
	@GetMapping("/getByCandidateId")
	public DataResult<List<Resume>> getByCandidateId(@RequestParam int id)
	{
		return resumeService.getByCandidateId(id);
	}
	
	@GetMapping("/getById")
	DataResult<Resume> getById(@RequestParam int id){
		return resumeService.getById(id);
	}
	
	@GetMapping("/getAll")
	DataResult<List<Resume>> getAll(){
		return resumeService.getAll();
	};
	@GetMapping("/getByTalentName")
	public DataResult<List<Resume>> getByTalentName(@RequestParam String talentName){
		return resumeService.getByTalentName(talentName);
	}
	@GetMapping("/getByLanguageName")
	public DataResult<List<Resume>> getByLanguageName(@RequestParam String language){
		return resumeService.getByLanguageName(language);
	}
	@GetMapping("/getByGraduationDegree")
	public DataResult<List<Resume>> getByGraduationDegree(@RequestParam String degree){
		return resumeService.getByGraduationDegree(degree);
	}
	@GetMapping("/getByWorkedJobPosition")
	public DataResult<List<Resume>> getByWorkedJobPosition(@RequestParam String position){
		return resumeService.getByWorkedJobPosition(position);
	}
	
	@PostMapping("/addOrUpdateGraduation")
	public Result addOrUpdateGraduation(@RequestBody @Valid GraduationDto graduationDto) {
		
		return resumeService.addOrUpdateGraduation(graduationDto);
	}
	@PostMapping("/addOrUpdateJobExperience")
	public Result addOrUpdateJobExperience(@RequestBody @Valid JobExperienceDto jobExperienceDto) {
		
		return resumeService.addOrUpdateJobExperience(jobExperienceDto);
	}
	@PostMapping("/addOrUpdateTalent")
	public Result addOrUpdateTalent(@RequestBody @Valid TalentDto talentDto) {
		
		return resumeService.addOrUpdateTalent(talentDto);		
	}
	@PostMapping("/addOrUpdateWebAddress")
	public Result addOrUpdateWebAddress(@RequestBody @Valid WebAddressDto webAddressDto) {
		
		return resumeService.addOrUpdateWebAddress(webAddressDto);
		
	}
	@PostMapping("/addOrUpdateLanguage")
	public Result addOrUpdateLanguage(@RequestBody @Valid LanguageDto languageDto) {
		
		return resumeService.addOrUpdateLanguage(languageDto);
	}
	
	
	
	
	
}
