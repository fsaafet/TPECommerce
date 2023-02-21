package com.ECommerce.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.Role;
import com.ECommerce.Ecommerce.Repository.RoleRepository;


;
@Service
public class RoleService {

	@Autowired
	RoleRepository repo;
	
	
	public Role getById(int id ) {
		return repo.findById(id).orElse(null);
	}
	
	
	public List<Role>getAllRoles(){
		return repo.findAll();
	}
	
	
	public void delete(int id ) {
		Role R=repo.findById(id).orElse(null);
		if(R!=null) repo.delete(R);
	}
	public void create (Role R) {
	  repo.save(R);
	}
	
	public void update (int id,Role R ) {
		Role  RoleInDB=repo.findById(id).orElse(null);
	if(R!=null) {
	    
		RoleInDB.setRoleName(R.getRoleName());
		
		repo.save(RoleInDB);
		}
		
}

}