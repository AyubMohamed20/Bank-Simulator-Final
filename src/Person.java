/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 9
*Date: April 17th, 2019
*/
/**
 * This class is the used to simulate a persons personal and account
 * information.
 *
 * 
 * @author Ayub Mohamed
 * @version 1.0
 * @since 1.8
 */
public class Person {
	// declares first Name, last name and email address
	private String firstName;
	private String lastName;
	private String emailAddress;

	/**
	 * Constructs and initializes the variables firstName, lastName, phoneNumber and
	 * emailAddress
	 * 
	 * @param firstname
	 *            The person's first name
	 * @param lastname
	 *            The person's last name
	 * @param emailAddress
	 *            The person's email address
	 */
	public Person(String firstName, String lastName, String emailAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	/**
	 * This method gets the full name when called
	 * 
	 * @return firstName, lastName
	 */
	public String Name() {
		// will get the full name
		return (firstName + " " + lastName);
	}

	/**
	 * This method gets first name when called
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		// will get the first name
		return firstName;
	}

	/**
	 * This method gets last name when called
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		// will get the last name
		return lastName;
	}

	/**
	 * This method gets the email address when called
	 * 
	 * @return emailAddress
	 */

	public String getEmail() {
		// will get the email
		return emailAddress;
	}

}
