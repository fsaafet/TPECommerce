package com.ECommerce.Ecommerce.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;



@Entity @Table(name="payement")
@Getter @Setter  @AllArgsConstructor @ToString
public abstract class payement {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
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
