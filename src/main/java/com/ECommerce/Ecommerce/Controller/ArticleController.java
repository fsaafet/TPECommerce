package com.ECommerce.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.Ecommerce.Entity.Article;

import com.ECommerce.Ecommerce.Service.ArticleService;

import com.github.javafaker.Faker;


@RestController
@RequestMapping("/article")
public class ArticleController {

	
	@Autowired
	ArticleService aService;
	
	@PostMapping
	public Article postarticle() {
		
		Article a=new Article();
		Faker f=new Faker();
		
		a.setBrand(f.lorem().paragraph());
		a.setDescription(f.lorem().characters());
		a.setPrice(f.number().randomDigit());
		aService.create(a);
		
		return a;
		
	}
	
}
