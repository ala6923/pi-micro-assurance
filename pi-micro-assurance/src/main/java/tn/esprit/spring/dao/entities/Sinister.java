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
	
	public Sinister() {
		
	}


	public Sinister(int id, Date declarationDate, Date sinisterDate, String sinisterPlace, int sinisterNumber,
			String sinisterDescription, String sinisterStatus, String sinisterType, Set<Arrangment> arrangments,
			Contract contract) {
		super();
		this.id = id;
		this.declarationDate = declarationDate;
		this.sinisterDate = sinisterDate;
		this.sinisterPlace = sinisterPlace;
		this.sinisterNumber = sinisterNumber;
		this.sinisterDescription = sinisterDescription;
		this.sinisterStatus = sinisterStatus;
		this.sinisterType = sinisterType;
		this.arrangments = arrangments;
		this.contract = contract;
	}


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
	private Set<Arrangment> arrangments;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Contract contract;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDeclarationDate() {
		return declarationDate;
	}


	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}


	public Date getSinisterDate() {
		return sinisterDate;
	}


	public void setSinisterDate(Date sinisterDate) {
		this.sinisterDate = sinisterDate;
	}


	public String getSinisterPlace() {
		return sinisterPlace;
	}


	public void setSinisterPlace(String sinisterPlace) {
		this.sinisterPlace = sinisterPlace;
	}


	public int getSinisterNumber() {
		return sinisterNumber;
	}


	public void setSinisterNumber(int sinisterNumber) {
		this.sinisterNumber = sinisterNumber;
	}


	public String getSinisterDescription() {
		return sinisterDescription;
	}


	public void setSinisterDescription(String sinisterDescription) {
		this.sinisterDescription = sinisterDescription;
	}


	public String getSinisterStatus() {
		return sinisterStatus;
	}


	public void setSinisterStatus(String sinisterStatus) {
		this.sinisterStatus = sinisterStatus;
	}


	public String getSinisterType() {
		return sinisterType;
	}


	public void setSinisterType(String sinisterType) {
		this.sinisterType = sinisterType;
	}


	public Set<Arrangment> getArrangments() {
		return arrangments;
	}


	public void setArrangments(Set<Arrangment> arrangments) {
		this.arrangments = arrangments;
	}


	public Contract getContract() {
		return contract;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}


	@Override
	public String toString() {
		return "Sinister [id=" + id + ", declarationDate=" + declarationDate + ", sinisterDate=" + sinisterDate
				+ ", sinisterPlace=" + sinisterPlace + ", sinisterNumber=" + sinisterNumber + ", sinisterDescription="
				+ sinisterDescription + ", sinisterStatus=" + sinisterStatus + ", sinisterType=" + sinisterType
				+ ", arrangments=" + arrangments + ", contract=" + contract + "]";
	}

	
	
	
	
	
	
	
	
	
	

}
