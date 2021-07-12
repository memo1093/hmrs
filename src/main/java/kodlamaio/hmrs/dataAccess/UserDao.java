package kodlamaio.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
