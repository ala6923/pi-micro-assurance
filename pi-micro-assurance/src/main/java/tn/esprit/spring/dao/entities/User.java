package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="User_ID")
	private long id = 1L;// Clé primaire
	
	@Column(name="USER_NAME" , length=50, nullable=false, unique=false)
	private String name;
	
	@Column(name="USER_FirstNAME", length=50, nullable=false, unique=false)
	private String firstname;
	
	@Column(name="USER_CIN", length=8, nullable=false, unique=false)
	private int Cin;
	
	@Column(name="USER_Email", length=40, nullable=false, unique=false)
	private String email;
	
	@Column(name="USER_PhoneNumber", length=15, nullable=false, unique=false)
	private int phoneNumber;
	
	@Column(name="USER_Address")
	private String address;
	
	@Column(name="USER_Login")
	private String login;
	
	@Column(name="USER_Password")
	private String password;
	
	@Column(name="USER_status")
	private String status;

/*	@Column(name="users_roles")
	@ManyToMany
	@JoinTable(name="Role")
//	private Collection<Role> role;*/
	
	private boolean isActived;



/*	private Collection<Role> roles;
	public User(boolean isActived) {
		super();
		this.isActived = isActived;
	}*/

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

	public User(long id, String name, String firstname, int cin, String email, int phoneNumber, String address,
			String login, String password, String status/*, /*Collection<Role> roles)*/ ){
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		Cin = cin;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.login = login;
		this.password = password;
		this.status = status;
		
	}

/*	public Collection<Role> getRoles() {
		return getRoles();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}*/

	public User(){};
	


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}

	public int getCin() {
		return Cin;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setCin(int cin) {
		Cin = cin;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
