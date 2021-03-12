package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "User_ID")
public class Insurer extends User  {
	
	@Column(name="InsurerMatricule")
	private String matricul;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> contracts;
	
	

}
