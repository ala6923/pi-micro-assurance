package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Arrangment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Arrangment_ID")
	private long id; // Clé primaire
	
	@Temporal (TemporalType.DATE)
	@Column(name="arrangmentDate")
	private Date arrangmentDate;
	
	@Column(name="expertCost")
	private int expertCost;
	
	@Column(name="franchise")
	private String franchise;
	
	@Column(name="indemnity")
	private String indemnity;
	
	@Column(name="arrangmentMethod")
	private String arrangmentMethod;
	
	@Column(name="amountArranged")
	private int amountArranged;
	public Arrangment(int id, Date arrangmentDate, int expertCost, String franchise, String indemnity,
			String arrangmentMethod, int amountArranged, Sinister sinister) {
		super();
		this.id = id;
		this.arrangmentDate = arrangmentDate;
		this.expertCost = expertCost;
		this.franchise = franchise;
		this.indemnity = indemnity;
		this.arrangmentMethod = arrangmentMethod;
		this.amountArranged = amountArranged;
		this.sinister = sinister;
	}

	public long getId() {
		return id;
	}

	public Date getArrangmentDate() {
		return arrangmentDate;
	}

	public int getExpertCost() {
		return expertCost;
	}

	public String getFranchise() {
		return franchise;
	}

	public String getIndemnity() {
		return indemnity;
	}

	public String getArrangmentMethod() {
		return arrangmentMethod;
	}

	public int getAmountArranged() {
		return amountArranged;
	}

	public Sinister getSinister() {
		return sinister;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArrangmentDate(Date arrangmentDate) {
		this.arrangmentDate = arrangmentDate;
	}

	public void setExpertCost(int expertCost) {
		this.expertCost = expertCost;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public void setIndemnity(String indemnity) {
		this.indemnity = indemnity;
	}

	public void setArrangmentMethod(String arrangmentMethod) {
		this.arrangmentMethod = arrangmentMethod;
	}

	public void setAmountArranged(int amountArranged) {
		this.amountArranged = amountArranged;
	}

	public void setSinister(Sinister sinister) {
		this.sinister = sinister;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	Sinister sinister;
	
	
	
	
	
	
	
	
	
	

}
