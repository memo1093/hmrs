package kodlamaio.hmrs.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.WebAddressService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.WebAddress;

@RestController
@RequestMapping("api/webAddresses")
public class WebAdressesController {

	
	private WebAddressService webAddressService;

	@Autowired
	public WebAdressesController(WebAddressService webAddressService) {
		super();
		this.webAddressService = webAddressService;
		
	}

	@GetMapping("/getByResumeId")
	DataResult<List<WebAddress>> getByResumeId(@RequestParam int id){
		
		return webAddressService.getByResumeId(id);
	}
}
