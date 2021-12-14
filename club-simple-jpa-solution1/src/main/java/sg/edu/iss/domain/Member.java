package sg.edu.iss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	
	private String firstName;
	private String secondName;
	private String lastName;
	private String username;
	private String password;
	
	
	public Member() {}

	public Member(Integer memberId, String firstName, String secondName, String lastName, String username,
			String password) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", lastName=" + lastName + ", username=" + username + ", password=" + password + "]";
	}



	
	
}
