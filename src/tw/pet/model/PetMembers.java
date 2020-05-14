package tw.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PetMembers")
public class PetMembers {
	private Integer memberId;
	private String email;
	private String password;
	private String username;
	private String gender;
	private Integer age;

	public PetMembers(String email, String password, String username, String gender, Integer age) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.age = age;
	}

	public PetMembers() {
	}

	@Id
	@Column(name = "memberId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "PetMembers {") ;
		sb.append("memberId='").append(memberId).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", username='").append(username).append('\'');
		sb.append(", gender='").append(gender).append('\'');
		sb.append(", age='").append(age).append('\'');
		sb.append('}');
		return sb.toString();		
			
	}

}
