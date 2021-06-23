package kodlamaio.hmrs.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.validationHandlers.ValidationHandler;
import kodlamaio.hmrs.entities.concretes.City;

@RestController
@RequestMapping("api/cities")
@CrossOrigin
public class CityController extends ValidationHandler{
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll(){
		return cityService.getAll();
	}
	
	public Result add(City city) {
		return cityService.add(city);
	}

}
