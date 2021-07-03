package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Graduation;


public interface GraduationService {
	DataResult<List<Graduation>> getBySchoolNameContains(String schoolName);
	DataResult<List<Graduation>> getBySchoolDegree(String degree);
	DataResult<List<Graduation>> getBySchoolDepartment(String department);
	DataResult<List<Graduation>> getByStillStudyingFalse();
	DataResult<List<Graduation>> getByStillStudyingTrue();
	DataResult<List<Graduation>> getByEndDate();
	DataResult<List<Graduation>> getByResumeId(int id);
	
	Result add(Graduation graduation);
	Result delete(int id);
	
	

}
