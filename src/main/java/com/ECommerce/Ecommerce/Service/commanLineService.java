package com.ECommerce.Ecommerce.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.CommandLine;

import com.ECommerce.Ecommerce.Repository.CommanLineRepository;

@Service
public class commanLineService {

	@Autowired
	CommanLineRepository cLrepo;
	
	public CommandLine  getById(int id ) {
		return cLrepo.findById(id).orElse(null);
	}
	
	public void create (CommandLine cl) {
		  cLrepo.save(cl);
		}
	
	
}
