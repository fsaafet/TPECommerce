package com.ECommerce.Ecommerce.Entity;



import javax.persistence.*;



import lombok.*;


@Entity @Table(name="userinformation")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor   @ToString
public class UserInformation {
	

	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int id ;

private String adress;
private String city;
private String email;
private String phonenumber;
public UserInformation(String adress, String city, String email, String phonenumber) {
	super();
	this.adress = adress;
	this.city = city;
	this.email = email;
	this.phonenumber = phonenumber;
}






}
