package com.ECommerce.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.User;
import com.ECommerce.Ecommerce.Entity.payement;
import com.ECommerce.Ecommerce.Repository.PayementRepository;

@Service
public class PayementService {

	
	@Autowired
	PayementRepository rep;
	
	public payement getById(int id ) {
		return rep.findById(id).orElse(null);
	}
	
	
	public List<payement>getAllPayements(){
		return rep.findAll();
	}
	
	
	public void delete(int id ) {
		payement p=rep.findById(id).orElse(null);
		if(p!=null) rep.delete(p);
	}
	public void create (payement p) {
	  rep.save(p);
	}
	
	public void update (int id,payement p ) {
		payement payementInDB=rep.findById(id).orElse(null);
	if(p!=null) {
		
		 payementInDB.setAmmount(p.getAmmount());
		 payementInDB.setPayementDate(p.getPayementDate());
		 
		rep.save(payementInDB);
		}
		
		
	}

}
