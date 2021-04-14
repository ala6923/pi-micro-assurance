package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String role;
	private String description;
	public String getRole() {
		return role;
	}
	public String getDescription() {
		return description;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	
	

}
