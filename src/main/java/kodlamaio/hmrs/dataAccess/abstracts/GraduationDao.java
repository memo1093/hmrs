package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hmrs.entities.concretes.Graduation;
import kodlamaio.hmrs.entities.dtos.GraduationDto;

public interface GraduationDao extends JpaRepository<Graduation,Integer>{
	
	List<Graduation> getBySchoolNameContains(String schoolName);
	List<Graduation> getBySchoolDegree(String degree);
	List<Graduation> getBySchoolDepartment(String department);
	List<Graduation> getByStillStudyingFalse();
	List<Graduation> getByStillStudyingTrue();
	@Query("From Graduation g ORDER BY g.endDate desc")
	List<Graduation> getByEndDate();
	Graduation save(GraduationDto graduationDto);
	List<Graduation> getByResume_Id(int id);

}
