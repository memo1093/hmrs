package kodlamaio.hmrs.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
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
public class ResumesController extends ValidationHandler {
	private ResumeService resumeService;
	private ModelMapper modelMapper;
	
	@Autowired
	public ResumesController(ResumeService resumeService, ModelMapper modelMapper) {
		super();
		this.resumeService = resumeService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("/addResume")
	public Result addResume(@RequestBody @Valid ResumeDto resumeDto) 
	{
		Resume resume = modelMapper.map(resumeDto, Resume.class);
		return resumeService.add(resume);
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
	
	@PostMapping("/addGraduation")
	public Result addGraduation(@RequestBody @Valid GraduationDto graduationDto) {
		
		return resumeService.addGraduation(graduationDto);
	}
	@PostMapping("/addJobExperience")
	public Result addJobExperience(@RequestBody @Valid JobExperienceDto jobExperienceDto) {
		
		return resumeService.addJobExperience(jobExperienceDto);
	}
	@PostMapping("/addTalent")
	public Result addTalent(@RequestBody @Valid TalentDto talentDto) {
		
		return resumeService.addTalent(talentDto);		
	}
	@PostMapping("/addWebAddress")
	public Result addWebAddress(@RequestBody @Valid WebAddressDto webAddressDto) {
		
		return resumeService.addWebAddress(webAddressDto);
		
	}
	@PostMapping("/addLanguage")
	public Result addLanguage(@RequestBody @Valid LanguageDto languageDto) {
		
		return resumeService.addLanguage(languageDto);
	}
	
	
	
	
	
}
