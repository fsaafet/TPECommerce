package com.ECommerce.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce.Ecommerce.Entity.Command;



public interface CommandRepository extends JpaRepository<Command,Integer>{

}
