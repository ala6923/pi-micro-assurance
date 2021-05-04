package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="vote_ID")
	private int id; // Clé primaire
	
	@Column
	private int voteValue;
	
	@JsonIgnore
	@ManyToOne 
	private Item item ;
	
	@ManyToOne
	private Insured insured;
	
	public Vote() {
		
	}
	
	public Vote(int id,int value) {
		super();
		this.id = id;
		this.voteValue = value;
	}
	
	public Vote(int value) {
		this.voteValue = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	
	

}
