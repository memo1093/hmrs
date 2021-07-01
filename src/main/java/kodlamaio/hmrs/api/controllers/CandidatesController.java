package kodlamaio.hmrs.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.FavoriteJobAdvertisement;
import kodlamaio.hmrs.entities.dtos.CandidateDto;
import kodlamaio.hmrs.entities.dtos.FavoriteJobAdvertisementDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController extends ValidationHandler {
	private CandidateService candidateService;
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService=candidateService;
	}
	@GetMapping("/getAll")
	public DataResult<Page<Candidate>> getCandidates(@RequestParam int pageNo,@RequestParam int pageSize){
		return this.candidateService.getAll(pageNo,pageSize);
	}
	@GetMapping("/get")
	public DataResult<Candidate> getCandidate(int id){
		return this.candidateService.get(id);
	}
	@PostMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody @Valid CandidateDto candidateDto){
		return this.candidateService.addOrUpdate(candidateDto);
	}
	@PostMapping("/addProfilePicture")
	public Result addCandidatesImage(@RequestBody MultipartFile file,@RequestParam int userId){
		return this.candidateService.saveImage(file, userId);
	}
	
	@PostMapping("/addToFavorites")
	DataResult<Integer> addToFavorites(@RequestBody @Valid FavoriteJobAdvertisementDto favoriteJobAdvertisementDto) {
		return candidateService.addToFavorites(favoriteJobAdvertisementDto);
	}
	@DeleteMapping("/deleteFromFavorites")
	Result deleteFromFavorites(@RequestParam int favoriteJobAdvertisementId ) {
		return candidateService.deleteFromFavorites(favoriteJobAdvertisementId);
	}
	
	
}

