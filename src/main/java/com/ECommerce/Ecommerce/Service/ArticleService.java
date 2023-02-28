package com.ECommerce.Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.Ecommerce.Entity.Article;

import com.ECommerce.Ecommerce.Repository.ArticleRepository;
@Service
public class ArticleService {

	@Autowired
	ArticleRepository aRepos;
	
	public Article getById(int id ) {
		return aRepos.findById(id).orElse(null);
	}
	
	public void create (Article a) {
		  aRepos.save(a);
		}
		
	
	
}
