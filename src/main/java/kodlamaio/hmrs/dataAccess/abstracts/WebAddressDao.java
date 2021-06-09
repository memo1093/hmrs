package kodlamaio.hmrs.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.WebAddress;

public interface WebAddressDao extends JpaRepository<WebAddress, Integer>{
	
	List<WebAddress> getByResume_Id(int id);
	
	
}
