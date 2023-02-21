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
import com.ECommerce.Ecommerce.Service.CommandService;
import com.github.javafaker.Faker;

@RestController
@RequestMapping ("/command")

public class CommandController {

	
	
	@Autowired
	CommandService cService;

	@GetMapping("/{id}")
	public Command getCommandById(@PathVariable("id")int id)
	{
 return cService.getById(id);
	}
	
	
	@GetMapping
	public List<Command>getAll(){
		return cService.getAllCommand();
	}
	
	
	@PostMapping
	public void postCommand() {
		Command c = new Command();
		Faker f=new Faker();
	
		c.setCommanDate(f.date().birthday());
		cService.create(c);
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
