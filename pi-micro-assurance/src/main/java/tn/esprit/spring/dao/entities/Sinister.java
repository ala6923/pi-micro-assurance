package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sinister implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Sinister_ID")
	private int id; // Clé primaire
	
	@Temporal (TemporalType.DATE)
	private Date declarationDate;
	
	@Temporal (TemporalType.DATE)
	private Date sinisterDate;
	
	@Column(name="sinisterPlace")
	private String sinisterPlace;
	
	@Column(name="sinisterNumber")
	private int sinisterNumber;
	
	@Column(name="sinisterDescription")
	private String sinisterDescription;
	
	@Column(name="sinisterStatus")
	private String sinisterStatus;
	
	@Column(name="sinisterType")
	private String sinisterType;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Amendment> amendments;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Arrangment> arrangments;
	

	
	
	
	
	
	
	
	
	
	

}
