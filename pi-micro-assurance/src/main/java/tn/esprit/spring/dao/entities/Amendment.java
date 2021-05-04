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
public class Amendment implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Amendment_ID")
	private long id; // Clé primaire
	
	@Temporal (TemporalType.DATE)
	private Date amendmentDate;
	public long getId() {
		return id;
	}

	public Date getAmendmentDate() {
		return amendmentDate;
	}

	public Contract getContract() {
		return contract;
	}

	public Sinister getSinister() {
		return sinister;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAmendmentDate(Date amendmentDate) {
		this.amendmentDate = amendmentDate;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public void setSinister(Sinister sinister) {
		this.sinister = sinister;
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Contract contract;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Sinister sinister;
	
}
