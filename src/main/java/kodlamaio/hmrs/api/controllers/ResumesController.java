package kodlamaio.hmrs.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Graduation;
import kodlamaio.hmrs.entities.concretes.JobExperience;
import kodlamaio.hmrs.entities.concretes.Language;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.concretes.Talent;
import kodlamaio.hmrs.entities.concretes.WebAddress;
import kodlamaio.hmrs.entities.dtos.GraduationDto;
import kodlamaio.hmrs.entities.dtos.JobExperienceDto;
import kodlamaio.hmrs.entities.dtos.LanguageDto;
import kodlamaio.hmrs.entities.dtos.ResumeDto;
import kodlamaio.hmrs.entities.dtos.TalentDto;
import kodlamaio.hmrs.entities.dtos.WebAddressDto;

@RestController
@RequestMapping("/api/resume")
public class ResumesController {
	private ResumeService resumeService;
	private ModelMapper modelMapper;
	
	@Autowired
	public ResumesController(ResumeService resumeService, ModelMapper modelMapper) {
		super();
		this.resumeService = resumeService;
		this.modelMapper = modelMapper;
	}
	@PostMapping("/add")
	public Result add(@RequestBody @Valid Resume resume) 
	{
		
		return resumeService.add(resume);
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
	@PostMapping("/addGraduation")
	public Result addGraduation(@RequestBody @Valid GraduationDto graduationDto) {
		Graduation graduation = modelMapper.map(graduationDto, Graduation.class);
		return resumeService.addGraduation(graduation);
	}
	@PostMapping("/addJobExperience")
	public Result addJobExperience(@RequestBody @Valid JobExperienceDto jobExperienceDto) {
		JobExperience jobExperience = modelMapper.map(jobExperienceDto, JobExperience.class);
		return resumeService.addJobExperience(jobExperience);
	}
	@PostMapping("/addTalent")
	public Result addTalent(@RequestBody @Valid TalentDto talentDto) {
		Talent talent = modelMapper.map(talentDto, Talent.class);
		return resumeService.addTalent(talent);
		
	}
	@PostMapping("/addWebAddress")
	public Result addWebAddress(@RequestBody @Valid WebAddressDto webAddressDto) {
		WebAddress webAddress = modelMapper.map(webAddressDto, WebAddress.class);
		return resumeService.addWebAddress(webAddress);
		
	}
	@PostMapping("/addLanguage")
	public Result addLanguage(@RequestBody @Valid LanguageDto languageDto) {
		Language language = modelMapper.map(languageDto, Language.class);
		return resumeService.addLanguage(language);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
		return errors;
	}
	
	
	
}
