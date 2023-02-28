package com.ECommerce.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.Ecommerce.Entity.CreditCardPayement;
import com.ECommerce.Ecommerce.Entity.PaypalPayement;
import com.ECommerce.Ecommerce.Entity.payement;
import com.ECommerce.Ecommerce.Service.PayementService;
import com.github.javafaker.Faker;

@RestController
@RequestMapping("/payement")
public class PayementController {

	@Autowired
	PayementService pService;
	
	@GetMapping("/{id}")
	public payement getUserById(@PathVariable("id")int id)
	{
 return pService.getById(id);
	}
	@GetMapping
	public List<payement> getAll(){
		return pService.getAllPayements();

	}
	@PostMapping
	public void postpayement() {
		payement p = new PaypalPayement();
		payement p1 =new CreditCardPayement();
		Faker f=new Faker();
		p.setAmmount(f.number().randomDigit());
	    p.setPayementDate(f.date().birthday()); 
	    p1.setAmmount(f.number().randomDigit());
	    p1.setPayementDate(f.date().birthday()); 
	  
		pService.create(p);
		pService.create(p1);
	}
}
