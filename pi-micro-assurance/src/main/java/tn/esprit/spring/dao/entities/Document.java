package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Document_ID")
	private Long id; // Clé primaire
	
	@Column(name="label")
	private String label;
	public Document(long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}


}
