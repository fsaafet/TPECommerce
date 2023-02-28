package com.ECommerce.Ecommerce.Entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="users")
@Getter @Setter @AllArgsConstructor   @ToString
public class User {

	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	private String password;
	private int connection;

	@OneToMany
	(targetEntity = Command.class,mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	 @JsonManagedReference
	 private List<Command> commands = new ArrayList<>();

	

	 @ManyToMany
     @JoinTable(name = "user_role_association",
     joinColumns = { @JoinColumn(name = "id_user") },
		        inverseJoinColumns = { @JoinColumn(name = "id_role") })
	 @JsonManagedReference
	   private List<Role> roles = new ArrayList<>();
		 
	

	 @OneToOne
	 @JoinColumn(name="UseriNFORMATION_ID" , referencedColumnName = "id")
	    private UserInformation userInformation;

	public User() {
		Faker faker=new Faker();
		this.login = faker.name().fullName();
		this.password = faker.code().asin();
		this.connection = faker.number().randomDigit();
		
		
		
		
	}

	




	

	




	
	
	
}
