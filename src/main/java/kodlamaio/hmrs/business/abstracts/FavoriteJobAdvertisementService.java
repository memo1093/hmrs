package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.FavoriteJobAdvertisement;

public interface FavoriteJobAdvertisementService {
	DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(int candidateId);
	DataResult<Page<FavoriteJobAdvertisement>> getByCandidateIdWithPages(int candidateId,int pageNo, int pageSize);
	DataResult<FavoriteJobAdvertisement> getById(int id);
	DataResult<Page<FavoriteJobAdvertisement>> getAll(int pageNo,int pageSize);
	
	DataResult<Integer> add(FavoriteJobAdvertisement favoriteJobAdvertisement);
	Result delete(int favoriteJobAdvertisementId);
}
