package kodlamaio.hmrs.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import kodlamaio.hmrs.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	private CandidateService candidateService;
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService=candidateService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getCandidates(){
		return this.candidateService.getAll();
	}
	@GetMapping("/get")
	public DataResult<Optional<Candidate>> getCandidate(int id){
		return this.candidateService.get(id);
	}
	@PostMapping("/add")
	public Result addCandidates(@RequestBody Candidate user){
		return this.candidateService.add(user);
	}
	@PostMapping("/addProfilePicture")
	public Result addCandidates(@RequestBody MultipartFile file,@RequestParam int userId){
		return this.candidateService.saveImage(file, userId);
	}
	
	
}

