package FirsMaven.MavenFirst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Studentinfo")
@Inheritance(strategy=InheritanceType.JOINED)
public class Student {
	@Id
	@Column(name="Person_ID")
	private Long Person_ID;

	@Column(name="Student_Name",length =30)
	private String Name;
	
	@Column(name="email_ID",length=50)
	private String email_ID;
	
	@Column(name="Major",length=50)
	private String major;
	
	/**
	 * @param person_ID
	 * @param name
	 * @param email_ID
	 * @param major
	 */
	public Student(Long person_ID, String name, String email_ID, String major) {
		
		Person_ID = person_ID;
		Name = name;
		this.email_ID = email_ID;
		this.major = major;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * @return the person_ID
	 */
	public Long getPerson_ID() {
		return Person_ID;
	}
	/**
	 * @param person_ID the person_ID to set
	 */
	public void setPerson_ID(Long person_ID) {
		Person_ID = person_ID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the email_IDString
	 */
	public String getEmail_ID() {
		return email_ID;
	}
	/**
	 * @param email_IDString the email_IDString to set
	 */
	public void setEmail_IDString(String email_ID) {
		this.email_ID = email_ID;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

}
