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

import com.ECommerce.Ecommerce.Entity.User;
import com.ECommerce.Ecommerce.Entity.UserInformation;
import com.ECommerce.Ecommerce.Service.UserInformationService;
import com.ECommerce.Ecommerce.Service.UserService;
import com.github.javafaker.Faker;
@RestController
@RequestMapping("/userinformation")
public class UserInformatinController {
	@Autowired
	UserService uService;
	
	
	@Autowired
	UserInformationService uinService;
	
	
	@GetMapping("/{id}")
	public UserInformation getUserInformationById(@PathVariable("id") int id) {
		return uinService.getById(id);
	}
	
	@GetMapping
	public List<UserInformation > getAll(){
		return uinService.getAll();
	}
	
	@PostMapping()
	public UserInformation postUserInformation () {
	
		
		UserInformation uin=new UserInformation();
		Faker  k=new Faker();
		uin.setAdress(k.address().fullAddress());
		uin.setCity(k.address().city());
		uin.setEmail(k.lorem().characters());
		uin.setPhonenumber(k.phoneNumber().phoneNumber());
		
		
		uinService.create(uin);
		return uin;
	}
	
	@PutMapping("/{id}")
	public void putUserInformation(@PathVariable("id") int id,@RequestBody UserInformation  uin) {
		uinService.update(id, uin);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserInformation(@PathVariable("id") int id) {
		uinService.delete(id);
	}
}
