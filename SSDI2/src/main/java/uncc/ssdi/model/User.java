package uncc.ssdi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Entity
@Table(name = "USERS")

public class User implements Serializable, IUser {

	@Id 
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@NotBlank
	private String firstname;

	@NotBlank
	private String lastname;

	@NotBlank
	private String password;

	@NotBlank
	private String emailid;

	
	public int getId() {
		return userid;
	}

	public void setId(int id) {
		this.userid = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String Emailid) {
		this.emailid = Emailid;
	}

}
