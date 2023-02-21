package com.ECommerce.Ecommerce.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.Ecommerce.Entity.Role;
import com.ECommerce.Ecommerce.Service.RoleService;
import com.github.javafaker.Faker;



@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService rService;
	
	
	@GetMapping("/{id}")
	public Role getRoleById(@PathVariable("id") int id) {
		return rService.getById(id);
	}
	@GetMapping
	public List<Role>getAllRoles(){
	return rService.getAllRoles();
	}
	@PostMapping
	public void postRole() {
		Role r = new Role();
		Faker f=new Faker();
		r.setRoleName(f.lorem().characters());
		rService.create(r);
	}
	
	@PutMapping("/{id}")
	public void putRole(@PathVariable("id") int id,@RequestBody Role r ) {
		rService.update(id, r);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable("id") int id) {
		rService.delete(id);
	}
	
}
