package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;
import kodlamaio.hmrs.entities.filters.JobPositionAdvertisementFilter;

public interface JobPositionAdvertisementDao extends JpaRepository<JobPositionAdvertisement,Integer>{
	List<JobPositionAdvertisement> findAllByIsStillActiveTrue(Pageable pageable);
	List<JobPositionAdvertisement> findAllByIsStillActiveTrueAndJobPosition_idIn(Pageable pageable,List<Integer> ids);
	List<JobPositionAdvertisement> findAllByIsStillActiveTrueAndEmployer_companyNameContains(Pageable pageable,String companyName);
	@Query("From JobPositionAdvertisement where is_still_active=true order by release_date Desc ")
	List<JobPositionAdvertisement> findAllByIsStillActiveTrueAndReleaseDate(Pageable pageable);
	List<JobPositionAdvertisement> findAllByJobPosition_Id(Pageable pageable,int id);
	List<JobPositionAdvertisement> findAllByCity_Id(Pageable pageable,int id);
	List<JobPositionAdvertisement> findAllByCity_IdOrJobPosition_IdIn(Pageable pageable,int cityId,List<Integer> ids);
	
	@Query("Select j from kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
	        +" and ((:#{#filter.jobTypeId}) IS NULL OR j.jobType.id IN (:#{#filter.jobTypeId}))"
	        +" and ((:#{#filter.jobTimeId}) IS NULL OR j.jobTime.id IN (:#{#filter.jobTimeId}))"
	        +" and (cast((:#{#filter.date}) AS timestamp)  IS NULL OR j.releaseDate<=(:#{#filter.date}))"
	        +" and j.isStillActive=true ORDER BY j.releaseDate DESC")
	Page<JobPositionAdvertisement> getByFilter(@Param("filter")JobPositionAdvertisementFilter jobPositionAdvertisementFilter, Pageable pageable);

	
	
}
