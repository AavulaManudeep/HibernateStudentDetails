/**
 * 
 */
package FirsMaven.MavenFirst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author manu
 *
 */
@Entity
@Table(name="Registrations")
@PrimaryKeyJoinColumn(name="Person_ID")
public class Registration extends Student {

	/**
	 * 
	 */
		@Column(name="ClassName")
		private String Class_Name;
		
		@Column(name="Day")
		private String Day;
	
	/**
		 * @param class_Name
		 * @param day
		 */
		public Registration(Long person_ID, String name, String email_ID , String major,String class_Name, String day) {
			super(person_ID, name, email_ID, major);
			Class_Name = class_Name;
			Day = day;
		}

	public Registration() {
		// TODO Auto-generated constructor stub
	}

}
