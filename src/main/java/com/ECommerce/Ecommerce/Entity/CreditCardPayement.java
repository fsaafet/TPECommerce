package com.ECommerce.Ecommerce.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table


@Getter @Setter @AllArgsConstructor @ToString
public class CreditCardPayement  extends payement{

	
	private String cardNumberString;
	private Date expirationDate;
	
	
	
	
}
