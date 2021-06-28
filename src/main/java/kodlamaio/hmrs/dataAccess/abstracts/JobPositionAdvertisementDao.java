package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;

public interface JobPositionAdvertisementDao extends JpaRepository<JobPositionAdvertisement,Integer>, JpaSpecificationExecutor<JobPositionAdvertisement>{
	List<JobPositionAdvertisement> findAllByIsStillActiveTrue(Pageable pageable);
	List<JobPositionAdvertisement> findAllByIsStillActiveTrueAndJobPosition_idIn(Pageable pageable,List<Integer> ids);
	List<JobPositionAdvertisement> findAllByIsStillActiveTrueAndEmployer_companyNameContains(Pageable pageable,String companyName);
	@Query("From JobPositionAdvertisement where is_still_active=true order by release_date Desc ")
	List<JobPositionAdvertisement> findAllByIsStillActiveTrueAndReleaseDate(Pageable pageable);
	List<JobPositionAdvertisement> findAllByJobPosition_Id(Pageable pageable,int id);
	List<JobPositionAdvertisement> findAllByCity_Id(Pageable pageable,int id);
	List<JobPositionAdvertisement> findAllByCity_IdOrJobPosition_IdIn(Pageable pageable,int cityId,List<Integer> ids);

	
	
}
