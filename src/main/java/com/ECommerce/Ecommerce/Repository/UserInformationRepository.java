package com.ECommerce.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce.Ecommerce.Entity.UserInformation;




public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {

}
