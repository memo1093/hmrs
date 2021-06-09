package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.TalentService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Talent;

@RestController
@RequestMapping("api/talents")
public class TalentsController {
	@Autowired
	private TalentService talentService;
	
	@GetMapping("/getByName")
	public DataResult<List<Talent>> getByNameContains(String name) {
		
		return talentService.getByNameContains(name);
	}
}
