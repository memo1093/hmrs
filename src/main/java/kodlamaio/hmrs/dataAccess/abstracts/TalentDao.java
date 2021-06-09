package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Talent;

public interface TalentDao extends JpaRepository<Talent,Integer>{
	List<Talent> getByNameContains(String name);
}
