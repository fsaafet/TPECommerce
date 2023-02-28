package com.ECommerce.Ecommerce.Entity;





import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Table(name="userrole")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Role {
	
	
	 @ManyToMany(cascade = CascadeType.ALL
		      )
		  @JoinTable(name = "user_role_association",
		   joinColumns = { @JoinColumn(name = "id_role") },
		   inverseJoinColumns = { @JoinColumn(name = "id_user") })
	@JsonBackReference
		  private List<User> users ;
		 
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id_role")
    private int id ;
	private String roleName;
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
     
	
	
	
	
}
