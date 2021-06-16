package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume,Integer>{
	List<Resume> getByCandidate_Id(int id);
	List<Resume> getByTalents_NameContains(String name);
	List<Resume> getByGraduations_SchoolDegreeContains(String name);
	List<Resume> getByLanguages_languageContains(String name);
	List<Resume> getByJobExperiences_positionContains(String name);
		
}
