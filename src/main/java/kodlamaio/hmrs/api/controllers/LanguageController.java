package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Language;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/getByName")
	DataResult<List<Language>> getByLanguageContains(@RequestParam String name){
		return languageService.getByLanguageContains(name);
	}
}
