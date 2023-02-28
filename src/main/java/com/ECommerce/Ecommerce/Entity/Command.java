package com.ECommerce.Ecommerce.Entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="command")
@Getter @Setter @AllArgsConstructor  @NoArgsConstructor @ToString
public class Command {
	
    @OneToOne(mappedBy="command")
    private payement payement;

	
	
	@ManyToOne
	@JoinTable(name="T_Command_Users_Associations",
	  joinColumns = @JoinColumn(name="idCommand"),
	  inverseJoinColumns =@JoinColumn(name="idUser")
	)
private User user;	
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
	
	
	
    private Date commanDate;

    
    public Command(Date commanDate) {
	super();
	this.commanDate = commanDate;
}


	
	
	
}
