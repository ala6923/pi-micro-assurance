package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Register_ID")
	private int id; // Clé primaire
	
	@Column(name="registerLabel")
	private String registerLabel;
	public Register(int id, String registerLabel) {
		super();
		this.id = id;
		this.registerLabel = registerLabel;
	}

	public int getId() {
		return id;
	}

	public String getRegisterLabel() {
		return registerLabel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRegisterLabel(String registerLabel) {
		this.registerLabel = registerLabel;
	}


}
