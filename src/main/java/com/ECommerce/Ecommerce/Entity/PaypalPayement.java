package com.ECommerce.Ecommerce.Entity;



import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="T_PayPalPayement")
@PrimaryKeyJoinColumn( name = "id" )
@Getter @Setter @ToString  @AllArgsConstructor @NoArgsConstructor
public class PaypalPayement extends payement {

	
	private String accountNumber;

	
	
}
