package kodlamaio.hmrs.business.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.FavoriteJobAdvertisement;
import kodlamaio.hmrs.entities.dtos.CandidateDto;
import kodlamaio.hmrs.entities.dtos.FavoriteJobAdvertisementDto;


public interface CandidateService{
	DataResult<Page<Candidate>> getAll(int pageNo, int pageSize);
	DataResult<Candidate> get(int id);
	
	DataResult<Integer> addToFavorites(FavoriteJobAdvertisementDto favoriteJobAdvertisementDto);
	Result deleteFromFavorites(int favoriteJobAdvertisementId);
	Result addOrUpdate(CandidateDto userDto);
	Result saveImage(MultipartFile file,int candidateId);
}
