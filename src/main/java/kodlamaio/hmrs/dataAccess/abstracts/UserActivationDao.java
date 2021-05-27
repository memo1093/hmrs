package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.UserActivation;

public interface UserActivationDao extends JpaRepository<UserActivation,Integer>{

}
