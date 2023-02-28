package com.ECommerce.Ecommerce.Controller;


import java.util.ArrayList;
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

import com.ECommerce.Ecommerce.Entity.Command;
import com.ECommerce.Ecommerce.Entity.Role;
import com.ECommerce.Ecommerce.Entity.User;
import com.ECommerce.Ecommerce.Entity.UserInformation;
import com.ECommerce.Ecommerce.Service.CommandService;
import com.ECommerce.Ecommerce.Service.RoleService;
import com.ECommerce.Ecommerce.Service.UserInformationService;
import com.ECommerce.Ecommerce.Service.UserService;
import com.github.javafaker.Faker;




@RestController
@RequestMapping ("/user")
public class UserController {

	@Autowired
	UserService uService;
    @Autowired
    UserInformationService uinService;
    @Autowired
	CommandService cService;
    @Autowired
	RoleService rService;
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id")int id)
	{
 return uService.getById(id);
	}
	
	
	@GetMapping
	public List<User> getAll(){
	return uService.getAllUsers();

	}
	
	
	
	
	@PostMapping("/infos/{id}")
	public User postUser(@PathVariable("id") int id) {
		User u = new User();		
	
		UserInformation userInfo=uinService.getById(id);
		Command c=cService.getById(id);
		Role r=rService.getById(id);
		List<Command> commands = new ArrayList<>();
		commands.add(c);
		List<Role> role=new ArrayList<>();
		role.add(r);
	
		Faker f=new Faker();
		u.setLogin(f.name().fullName());
		u.setPassword(f.code().asin());
		u.setConnection(f.number().numberBetween(0, 2));
		u.setUserInformation(userInfo);
		u.setCommands(commands);
		u.setRoles(role);
		uService.create(u);
		return u;
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
