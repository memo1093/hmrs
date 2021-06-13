package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;

public interface JobPositionAdvertisementDao extends JpaRepository<JobPositionAdvertisement,Integer>{
	List<JobPositionAdvertisement> getByIsStillActiveTrue();
	List<JobPositionAdvertisement> getByIsStillActiveTrueAndEmployer_companyNameContains(String companyName);
	@Query("From JobPositionAdvertisement where is_still_active=true order by release_date Desc ")
	List<JobPositionAdvertisement> getByIsStillActiveTrueAndReleaseDate();
	
	
}
