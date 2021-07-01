package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.GraduationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Graduation;

@RestController
@RequestMapping("api/graduations")
@CrossOrigin
public class GraduationsController {
	private GraduationService graduationService;

	@Autowired
	public GraduationsController(GraduationService graduationService) {
		super();
		this.graduationService = graduationService;
	}
	@GetMapping("/getBySchoolName")
	public DataResult<List<Graduation>> getBySchoolNameContains(@RequestParam String schoolName){
		return graduationService.getBySchoolNameContains(schoolName);
	}
	@GetMapping("/getBySchoolDegree")
	public DataResult<List<Graduation>> getBySchoolDegree(@RequestParam String degree){
		return graduationService.getBySchoolDegree(degree);
	}
	@GetMapping("/getBySchoolDepartment")
	public DataResult<List<Graduation>> getBySchoolDepartment(@RequestParam String department){
		return graduationService.getBySchoolDepartment(department);
	}
	@GetMapping("/getByStillStudyingFalse")
	public DataResult<List<Graduation>> getByStillStudyingFalse(){
		return graduationService.getByStillStudyingFalse();
	}
	@GetMapping("/getByStillStudyingTrue")
	public DataResult<List<Graduation>> getByStillStudyingTrue(){
		return graduationService.getByStillStudyingTrue();
	}
	@GetMapping("/getByEndDate")
	public DataResult<List<Graduation>> getByEndDate(){
		return graduationService.getByEndDate();
	}
	@GetMapping("/getByResumeId")
	public DataResult<List<Graduation>> getByResumeId(@RequestParam int resumeId) {
		
		return graduationService.getByResumeId(resumeId);
	}
	
	
}
