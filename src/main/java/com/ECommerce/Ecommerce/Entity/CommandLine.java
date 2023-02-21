package com.ECommerce.Ecommerce.Entity;

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

@Entity @Table(name="commandLine")
@Getter @Setter @AllArgsConstructor @ToString
public class CommandLine {
 @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int quantity;
	public CommandLine() {
		super();
		Faker f =new Faker();
		this.quantity = f.number().randomDigit();
	}
	
}
