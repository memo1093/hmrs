package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	List<JobExperience> getByCompanyNameContains(String name);
	List<JobExperience> getByStillWorkingFalse();
	List<JobExperience> getByPositionContains(String name);
}
