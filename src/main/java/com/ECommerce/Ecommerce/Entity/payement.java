package com.ECommerce.Ecommerce.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;



@Entity @Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter  @AllArgsConstructor @ToString
public abstract class payement {

   
	@OneToOne @JoinColumn(name="id")
	private Command command;
	
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id ;
	
	private float ammount ;
	private Date payementDate;
	public payement() {
		super();
		Faker fa =new Faker();
		this.ammount = fa.number().numberBetween(10, 1000000);
		this.payementDate = fa.date().birthday();
	}
	
	
}
