package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FavoriteJobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.FavoriteJobAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.FavoriteJobAdvertisement;

@Service
public class FavoriteJobAdvertisementManager implements FavoriteJobAdvertisementService {
	
	@Autowired
	private FavoriteJobAdvertisementDao favoriteJobAdvertisementDao;

	@Override
	public DataResult<Page<FavoriteJobAdvertisement>> getByCandidateIdWithPages(int candidateId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<FavoriteJobAdvertisement>>(favoriteJobAdvertisementDao.findAllByCandidate_Id(candidateId,pageable ), "İş arayana göre favori iş ilanları getirme işlemi başarılı!");
	}

	@Override
	public DataResult<FavoriteJobAdvertisement> getById(int id) {
		
		return new SuccessDataResult<FavoriteJobAdvertisement>(favoriteJobAdvertisementDao.findById(id).get(),"Favori iş ilanını getirme işlemi başarılı!");
	}

	@Override
	public DataResult<Page<FavoriteJobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<FavoriteJobAdvertisement>>(favoriteJobAdvertisementDao.findAll(pageable),"Tüm favori listesini getirme işlemi başarılı!");
	}

	
	@Override
	public DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<FavoriteJobAdvertisement>>(favoriteJobAdvertisementDao.findAllByCandidate_Id(candidateId), "İş arayana göre favori iş ilanları getirme işlemi başarılı!");
	}

	@Override
	public DataResult<Integer> add(FavoriteJobAdvertisement favoriteJobAdvertisement) {
		FavoriteJobAdvertisement savedFavoriteJobAdvertisement = favoriteJobAdvertisementDao.save(favoriteJobAdvertisement);
		return new SuccessDataResult<Integer>(savedFavoriteJobAdvertisement.getId(),"Favorilere Ekleme işlemi başarılı!");
	}

	@Override
	public Result delete(int favoriteJobAdvertisementId) {
		if (!favoriteJobAdvertisementDao.existsById(favoriteJobAdvertisementId)) {
			return new ErrorResult("Favori iş ilanı bulunamadı.");
		}
		favoriteJobAdvertisementDao.deleteById(favoriteJobAdvertisementId);
		return new SuccessResult("Favorilerden kaldırma işlemi başarılı!");
	}
	
}
