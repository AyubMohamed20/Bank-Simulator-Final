import java.util.Scanner;

/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 9
*Date: April 17th, 2019
*/
/**
 * This abstract class is the skeleton of any type of bank account and is used
 * to update, print and return the balance
 * 
 * @author Ayub Mohamed
 * @version 1.0
 * @since 1.8
 */
public abstract class BankAccount {
	/**
	 * accountNumber, the account number
	 */
	protected int accountNumber;

	/**
	 * accHolder, the person the account belongs too
	 */
	protected Person accHolder;
	/**
	 * balance, the balance of the account
	 */
	protected double balance;
	/**
	 * scanner allows for user inputs
	 */
	Scanner scanner = new Scanner(System.in);

	/**
	 * The default Constructor used to add account by user inputs
	 */
	public BankAccount() {

	}

	/**
	 * Constructs and initializes the variables in this class
	 * 
	 * @param balance
	 *            The stating account balance
	 * @param accountNumber
	 *            The account number
	 * @param accHolder
	 *            a instance of the class person
	 * 
	 */
	public BankAccount(int accountNumber, Person accHolder, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accHolder = accHolder;
		this.balance = balance;
	}

	/**
	 * When this method is called it print the account number, full name,mail and balance
	 * @return printAccount
	 */
	public String toString() {
		// code for the account holder personal information
		String printAccount = accHolder.Name() + " " + accountNumber + " " + accHolder.getEmail() + " " + balance;
		return printAccount;
	}

	/**
	 *This methods updates the balance 
	 * 
	 * @return success, returns true when all user input are valid
	 */

	public double updateBalance(double addAmount) {

		// code for updating the balance
		balance = balance + addAmount;
		return balance;

	}

	/**
	 * this method is abstract and must be over written
	 */
	public abstract void monthlyAccountUpdate();

}
