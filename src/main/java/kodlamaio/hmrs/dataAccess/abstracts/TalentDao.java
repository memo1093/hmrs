package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Talent;

public interface TalentDao extends JpaRepository<Talent,Integer>{

}
