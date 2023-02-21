package com.ECommerce.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.Command;
import com.ECommerce.Ecommerce.Repository.CommandRepository;




@Service
public class CommandService {
	@Autowired
	CommandRepository repo;
	
	
	public Command getById(int id ) {
		return repo.findById(id).orElse(null);
	}
	
	
	public List<Command> getAllCommand(){
		return repo.findAll();
	}
	
	
	public void delete(int id ) {
		Command c =repo.findById(id).orElse(null);
		if(c!=null) repo.delete(c);
	}
	public void create (Command c) {
	  repo.save(c);
	}
	
	public void update (int id,Command c ) {
		Command command=repo.findById(id).orElse(null);
	if(c!=null) {
		command.setCommanDate(c.getCommanDate());
		
		repo.save(command);
		}
		
		
	}


	
}
