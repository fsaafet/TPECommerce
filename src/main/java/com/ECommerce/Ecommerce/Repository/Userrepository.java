package com.ECommerce.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce.Ecommerce.Entity.User;

public interface Userrepository  extends JpaRepository<User, Integer>{

}
