package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="User_ID")
	private int id; // Clé primaire
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_FirstNAME")
	private String firstname;
	
	@Column(name="USER_CIN")
	private int Cin;
	
	@Column(name="USER_Email")
	private String email;
	
	@Column(name="USER_PhoneNumber")
	private int phoneNumber;
	
	@Column(name="USER_Adress")
	private String adress;
	
	@Column(name="USER_Login")
	private String login;
	
	@Column(name="USER_Password")
	private String password;
	
	@Column(name="USER_status")
	private String status;
	
	
	
	public User(){
		
	}
	
public User ( int id ,String name , String firstname ,int Cin ,String email, int phoneNumber ,String adress,String login ,String password,String status){
		
		
		this.id=id;
		this.name=name ;
		this.firstname=firstname ;
		this.Cin=Cin;
		this.email=email;
		this.phoneNumber=phoneNumber ;
		this.adress=adress ;
		this.login=login;
		this.password=password ;
		this.status=status;
	}


public User ( String name , String firstname ,int Cin ,String email, int phoneNumber ,String adress,String login ,String password,String status){
	
	
	
	this.name=name ;
	this.firstname=firstname ;
	this.Cin=Cin;
	this.email=email;
	this.phoneNumber=phoneNumber ;
	this.adress=adress ;
	this.login=login;
	this.password=password ;
	this.status=status;
}
	

public User(String name,String firstname){
	
	this.name=name ;
	this.firstname=firstname ;
	
}

}
