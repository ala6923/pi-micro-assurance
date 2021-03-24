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
	public Sinister(int id, Date declarationDate, Date sinisterDate, String sinisterPlace, int sinisterNumber,
			String sinisterDescription, String sinisterStatus, String sinisterType, Set<Amendment> amendments,
			Set<Arrangment> arrangments) {
		super();
		this.id = id;
		this.declarationDate = declarationDate;
		this.sinisterDate = sinisterDate;
		this.sinisterPlace = sinisterPlace;
		this.sinisterNumber = sinisterNumber;
		this.sinisterDescription = sinisterDescription;
		this.sinisterStatus = sinisterStatus;
		this.sinisterType = sinisterType;
		this.amendments = amendments;
		this.arrangments = arrangments;
	}

	public int getId() {
		return id;
	}

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public Date getSinisterDate() {
		return sinisterDate;
	}

	public String getSinisterPlace() {
		return sinisterPlace;
	}

	public int getSinisterNumber() {
		return sinisterNumber;
	}

	public String getSinisterDescription() {
		return sinisterDescription;
	}

	public String getSinisterStatus() {
		return sinisterStatus;
	}

	public String getSinisterType() {
		return sinisterType;
	}

	public Set<Amendment> getAmendments() {
		return amendments;
	}

	public Set<Arrangment> getArrangments() {
		return arrangments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}

	public void setSinisterDate(Date sinisterDate) {
		this.sinisterDate = sinisterDate;
	}

	public void setSinisterPlace(String sinisterPlace) {
		this.sinisterPlace = sinisterPlace;
	}

	public void setSinisterNumber(int sinisterNumber) {
		this.sinisterNumber = sinisterNumber;
	}

	public void setSinisterDescription(String sinisterDescription) {
		this.sinisterDescription = sinisterDescription;
	}

	public void setSinisterStatus(String sinisterStatus) {
		this.sinisterStatus = sinisterStatus;
	}

	public void setSinisterType(String sinisterType) {
		this.sinisterType = sinisterType;
	}

	public void setAmendments(Set<Amendment> amendments) {
		this.amendments = amendments;
	}

	public void setArrangments(Set<Arrangment> arrangments) {
		this.arrangments = arrangments;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Amendment> amendments;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Arrangment> arrangments;
	

	
	
	
	
	
	
	
	
	
	

}
