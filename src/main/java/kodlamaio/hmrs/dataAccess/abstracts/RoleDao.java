package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
	Role findByNameIgnoreCase(String name);
	
}
