package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operation implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Operation_ID")
	private int id; // Clé primaire
	
	@Column(name="operationLabel")
	private String operationLabel;
	public Operation(int id, String operationLabel) {
		super();
		this.id = id;
		this.operationLabel = operationLabel;
	}

	public int getId() {
		return id;
	}

	public String getOperationLabel() {
		return operationLabel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOperationLabel(String operationLabel) {
		this.operationLabel = operationLabel;
	}


}
