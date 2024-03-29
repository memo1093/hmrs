package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
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
@RequestMapping("/api/resumes")
@CrossOrigin(origins ="*",allowedHeaders = "*")

public class ResumesController extends ValidationHandler {
	@Autowired
	private ResumeService resumeService;

	//Get mappings
	
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
	
	// Post mappings - AddOrUpdate
	@PostMapping("/addResume")
	public DataResult<Resume> addResume(@RequestBody @Valid ResumeDto resumeDto) 
	{
		
		return resumeService.addOrUpdateResume(resumeDto);
	}
	
	@PostMapping("/addOrUpdateGraduation")
	public DataResult<Graduation> addOrUpdateGraduation(@RequestBody @Valid GraduationDto graduationDto) {
		
		return resumeService.addOrUpdateGraduation(graduationDto);
	}
	@PostMapping("/addOrUpdateJobExperience")
	public DataResult<JobExperience> addOrUpdateJobExperience(@RequestBody @Valid JobExperienceDto jobExperienceDto) {
		
		return resumeService.addOrUpdateJobExperience(jobExperienceDto);
	}
	@PostMapping("/addOrUpdateTalent")
	public DataResult<Talent> addOrUpdateTalent(@RequestBody @Valid TalentDto talentDto) {
		
		return resumeService.addOrUpdateTalent(talentDto);		
	}
	@PostMapping("/addOrUpdateWebAddress")
	public DataResult<WebAddress> addOrUpdateWebAddress(@RequestBody @Valid WebAddressDto webAddressDto) {
		
		return resumeService.addOrUpdateWebAddress(webAddressDto);
		
	}
	@PostMapping("/addOrUpdateLanguage")
	public DataResult<Language> addOrUpdateLanguage(@RequestBody @Valid LanguageDto languageDto) {
		
		return resumeService.addOrUpdateLanguage(languageDto);
	}
	@PostMapping("/addOrUpdateProfilePicture")
	public Result addOrUpdateProfilePicture(@RequestBody @Valid MultipartFile file,int resumeId) {
		
		return resumeService.saveImage(file,resumeId);
	}
	
	// Delete Mappings
	@DeleteMapping("/deleteResume")
	public Result deleteResume(@RequestParam int id) {
		return resumeService.deleteResume(id);
	}
	@DeleteMapping("/deleteGraduation")
	public Result deleteGraduation(@RequestParam int graduationId) {
		return resumeService.deleteGraduation(graduationId);
	}
	@DeleteMapping("/deleteTalent")
	public Result deleteTalent(@RequestParam int talentId) {
		return resumeService.deleteTalent(talentId);
	}
	@DeleteMapping("/deleteWebAddress")
	public Result deleteWebAddress(@RequestParam int webAddressId) {
		return resumeService.deleteWebAddress(webAddressId);
	}
	@DeleteMapping("/deleteJobExperience")
	public Result deleteJobExperience(@RequestParam int jobExperienceId) {
		return resumeService.deleteJobExperience(jobExperienceId);
	}
	@DeleteMapping("/deleteLanguage")
	public Result deleteLanguage(@RequestParam int languageId) {
		return resumeService.deleteLanguage(languageId);
	}
	
	
	
	
}
