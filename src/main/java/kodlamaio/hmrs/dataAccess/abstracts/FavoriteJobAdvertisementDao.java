package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.FavoriteJobAdvertisement;

public interface FavoriteJobAdvertisementDao extends JpaRepository<FavoriteJobAdvertisement, Integer>{
	List<FavoriteJobAdvertisement> findAllByCandidate_Id(int candidateId);
	Page<FavoriteJobAdvertisement> findAllByCandidate_Id(int candidateId,Pageable pageable);
}
