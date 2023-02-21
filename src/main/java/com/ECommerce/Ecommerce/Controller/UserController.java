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
import com.ECommerce.Ecommerce.Entity.User;

import com.ECommerce.Ecommerce.Service.UserService;
import com.github.javafaker.Faker;




@RestController
@RequestMapping ("/user")
public class UserController {

	@Autowired
	UserService uService;
	
@PostMapping("/user/{IdUser}/role")
public List<Role> addRoles(){



return uService.getAllRoles();

	
}
@GetMapping("/user/{IdUser}/role")
public List<Role> getAllRoles(@PathVariable ("idUser") int idUser){
	return uService.getAllRoles();
}

	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")int id)
	{
 return uService.getById(id);
	}
	
	@GetMapping
	public List<User> getAll(){
		return uService.getAllUsers();

	}
	
	@PostMapping
	public void postUser() {
		User u = new User();
		Faker f=new Faker();
		u.setLogin(f.name().fullName());
		u.setPassword(f.code().asin());
		u.setConnection(f.number().numberBetween(0, 2));
	  
		uService.create(u);
	}
	
	@PutMapping("/{id}")
	public void putUser(@PathVariable("id") int id,@RequestBody User u) {
		uService.update(id, u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		uService.delete(id);
	}
	
	
	
	
	
}
