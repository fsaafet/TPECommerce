package com.ECommerce.Ecommerce.Entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor   @ToString
public class User {

	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;
	private String login;
	private String password;
	private int connection;

	@OneToMany
	(targetEntity = Command.class,mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Command>commands=new ArrayList<>();

	

	 @ManyToMany
     @JoinTable(name = "user_role_association",
    joinColumns = { @JoinColumn(name = "id_user") },
		        inverseJoinColumns = { @JoinColumn(name = "id_role") })
	
		  private List<Role>roles =new ArrayList<>();
		 
	
	@OneToOne
	@JoinColumn(name="idUserInformation")
	private UserInformation userInformation;	

	public User(String login, String password, int connection, List<Command> commands, List<Role> roles,
			UserInformation userInformation) {
		super();
		this.login = login;
		this.password = password;
		this.connection = connection;
		this.commands = commands;
		this.roles = roles;
		this.userInformation = userInformation;
	}




	
	
	
}
