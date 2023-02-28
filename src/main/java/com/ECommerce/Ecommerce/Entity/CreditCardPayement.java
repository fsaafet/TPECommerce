package com.ECommerce.Ecommerce.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="T_CreditCardPayement")

@PrimaryKeyJoinColumn( name = "id" )
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class CreditCardPayement  extends payement{

	
	private String cardNumberString;
	private Date expirationDate;
	
	
	
	
}
