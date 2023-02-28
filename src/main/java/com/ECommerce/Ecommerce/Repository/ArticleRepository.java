package com.ECommerce.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce.Ecommerce.Entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
