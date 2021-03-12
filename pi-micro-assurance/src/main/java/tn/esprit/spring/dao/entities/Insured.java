package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@PrimaryKeyJoinColumn(name = "User_ID")
public class Insured extends User  {
	
	
	@Temporal (TemporalType.DATE)
	private Date recordingDate;
	
	@Column(name="Insured_health")
	private String healthStatus;
	
	@Column(name="Insured_CivilStatus")
	private String civilStatus;
	
	@Column(name="Insured_Age")
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> contracts;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Claims> claims;
	
	
	


}
