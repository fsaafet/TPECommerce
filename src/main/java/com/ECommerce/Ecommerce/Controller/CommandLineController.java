package com.ECommerce.Ecommerce.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.Ecommerce.Entity.Article;

import com.ECommerce.Ecommerce.Entity.CommandLine;
import com.ECommerce.Ecommerce.Service.ArticleService;
import com.ECommerce.Ecommerce.Service.CommandService;
import com.ECommerce.Ecommerce.Service.commanLineService;
import com.github.javafaker.Faker;
@RestController
@RequestMapping("/cline")

public class CommandLineController {

	@Autowired
	commanLineService clService;
	@Autowired
	ArticleService aService;
	@Autowired
	CommandService cService;

	@PostMapping("/article/{id}")
	public CommandLine postCommandLine(@PathVariable("id") int id) {
		CommandLine cl=new CommandLine();
		
		Article article=aService.getById(id);
		Faker f=new Faker();
		cl.setQuantity(f.number().randomDigit());
		cl.setArticle(article);
		
		clService.create(cl);
		
		return cl;
		
	}
	
	
	
}
