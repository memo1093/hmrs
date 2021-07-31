package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hmrs.entities.concretes.Role;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	@Query(value="Select r.name from users u inner join roles r on r.id=u.role_id where u.id=:id",nativeQuery = true)
	String getRoleByUserId(int id);
}
