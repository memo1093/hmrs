package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Graduation;

public interface GraduationDao extends JpaRepository<Graduation,Integer>{

}
