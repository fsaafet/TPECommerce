package com.ECommerce.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.Role;
import com.ECommerce.Ecommerce.Entity.User;
import com.ECommerce.Ecommerce.Repository.Userrepository;




@Service
public class UserService {
   
	@Autowired
	Userrepository repo;
	
	
	public User getById(int id ) {
		return repo.findById(id).orElse(null);
	}
	
	
	public List<User>getAllUsers(){
		return repo.findAll();
	}
	
	
	public void delete(int id ) {
		User u =repo.findById(id).orElse(null);
		if(u!=null) repo.delete(u);
	}
	public void create (User u) {
	  repo.save(u);
	}
	
	public void update (int id,User u ) {
		User userInDB=repo.findById(id).orElse(null);
	if(u!=null) {
		userInDB.setLogin(u.getLogin());
		userInDB.setPassword(u.getPassword());
		userInDB.setConnection(u.getConnection());
		repo.save(userInDB);
		}
		
		
	}



	
}    
