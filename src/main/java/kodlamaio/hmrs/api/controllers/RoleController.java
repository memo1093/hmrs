package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.RoleService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getAll")
	DataResult<List<Role>> getAll(){
		return roleService.getAll();
	}
	@GetMapping("/getById")
	DataResult<Role> getById(@RequestParam int id){
		return roleService.getById(id);
	}
	@GetMapping("/getByName")
	DataResult<Role> getById(@RequestParam String name){
		return roleService.getByName(name);
	}
	
	@PostMapping("/addOrUpdate")
	DataResult<Role> addOrUpdate(@RequestBody Role role){
		return roleService.addOrUpdate(role);
	}
}
