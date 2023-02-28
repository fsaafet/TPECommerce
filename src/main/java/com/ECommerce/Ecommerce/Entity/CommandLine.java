package com.ECommerce.Ecommerce.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="commandLine")
@Getter @Setter @AllArgsConstructor @ToString
public class CommandLine {
	
	 
	
	
	@ManyToOne @JoinColumn(name="id_command",nullable=false)
	private Command command;
	@ManyToOne()
	@JoinColumn(name="id_article",nullable = false)
	private Article article;
	
	
	
	
	
 @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
 
 
 
	private int quantity;
	public CommandLine() {
		super();
		Faker f =new Faker();
		this.quantity = f.number().randomDigit();
	}
	
}
