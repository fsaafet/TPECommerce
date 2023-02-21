package com.ECommerce.Ecommerce.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter @Setter @AllArgsConstructor @ToString
public class Article {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String description;
	private String brand;
	private float price;
	public Article(String description, String brand, float price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	
	
	
	
}
