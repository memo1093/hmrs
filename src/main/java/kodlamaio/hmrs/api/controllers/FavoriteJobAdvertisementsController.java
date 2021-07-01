package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.FavoriteJobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.FavoriteJobAdvertisement;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoriteJobAdvertisementsController extends ValidationHandler{
	
	@Autowired
	private FavoriteJobAdvertisementService favoriteJobAdvertisementService;
	@GetMapping("/getByCandidateIdWithPages")
	public DataResult<Page<FavoriteJobAdvertisement>> getByCandidateIdWithPages(@RequestParam int candidateId,@RequestParam int pageNo,@RequestParam int pageSize){
		return favoriteJobAdvertisementService.getByCandidateIdWithPages(candidateId, pageNo, pageSize);
	}
	@GetMapping("/getByCandidateId")
	DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(int candidateId){
		return favoriteJobAdvertisementService.getByCandidateId(candidateId);
	}
	@GetMapping("getById")
	public DataResult<FavoriteJobAdvertisement> getById(@RequestParam int id){
		return favoriteJobAdvertisementService.getById(id);
	}
	@GetMapping("/getAll")
	DataResult<Page<FavoriteJobAdvertisement>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
		return favoriteJobAdvertisementService.getAll(pageNo, pageSize);
	}
	
}
