package com.ECommerce.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.UserInformation;
import com.ECommerce.Ecommerce.Repository.UserInformationRepository;



@Service
public class UserInformationService {
 
	@Autowired
	UserInformationRepository repo;
	
	public UserInformation getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<UserInformation>getAll(){
		return repo.findAll();
	}
	
	public void delete (int id) {
		UserInformation uIn=repo.findById(id).orElse(null);
		if(uIn!=null) repo.delete(uIn);
	}
	
	public void create (UserInformation uIn) {
		repo.save(uIn);
	}
	
	public void update (int id ,UserInformation uIn) {
		UserInformation informationInDB=repo.findById(id).orElse(null);
		informationInDB.setAdress(uIn.getAdress());
		informationInDB.setCity(uIn.getCity());
		informationInDB.setEmail(uIn.getEmail());
		informationInDB.setPhonenumber(uIn.getPhonenumber());
		repo.save(informationInDB);
		
		
	}
}
