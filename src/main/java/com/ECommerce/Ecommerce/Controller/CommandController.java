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

import com.ECommerce.Ecommerce.Entity.Command;
import com.ECommerce.Ecommerce.Entity.payement;
import com.ECommerce.Ecommerce.Service.CommandService;
import com.ECommerce.Ecommerce.Service.PayementService;
import com.ECommerce.Ecommerce.Service.UserService;
import com.github.javafaker.Faker;

@RestController
@RequestMapping ("/command")

public class CommandController {

	@Autowired
	UserService uService;
	
	@Autowired
	CommandService cService;
	@Autowired
	PayementService pService;
	
	@GetMapping("/{id}")
	public Command getCommandById(@PathVariable("id")int id)
	{
 return cService.getById(id);
	}
	@PostMapping("/payement/{id}")
	public Command postCommand (@PathVariable("id") int id) {
	
		
		Command c=new Command();
		payement p=pService.getById(id);
				Faker  k=new Faker();
		c.setCommanDate(k.date().birthday());
		c.setPayement(p);
	    
		cService.create(c);
		return c;
	}
	
	
	@GetMapping
	public List<Command>getAll(){
		return cService.getAllCommand();
	}
	
	@PutMapping("/{id}")
	public void putCommand(@PathVariable("id") int id,@RequestBody Command c) {
		cService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommand(@PathVariable("id") int id) {
		cService.delete(id);
	}
	
	
}
