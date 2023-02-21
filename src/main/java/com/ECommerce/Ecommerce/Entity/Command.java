package com.ECommerce.Ecommerce.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.ECommerce.Ecommerce.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="command")
@Getter @Setter @AllArgsConstructor  @ToString
public class Command {
	
	@ManyToOne
	 @JoinColumn(name="idUser")
	@JsonIgnore
	private User user ;
	
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
private int idCommand ;
private Date commanDate;
public Command() {
	super();
	Faker faker =new Faker();
	this.commanDate = faker.date().birthday();
}


	
	
	
}
