package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.WebAddress;

public interface WebAddressDao extends JpaRepository<WebAddress,Integer>{

}
