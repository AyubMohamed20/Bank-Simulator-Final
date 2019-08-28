/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 9
*Date: April 17th, 2019
*/
/**
 * This class is a type of bank account, where the balance gets subtracted by
 * the fee. Extends the bank account class The class calculates and updates the
 * balance after the fee has been subtracted. Also, the class prints out the
 * chequing account info
 * 
 * @author Ayub Mohamed
 * @version 1.8
 * @since 1.0
 *
 */
public class ChequingAccount extends BankAccount {

	private double fee;

	/**
	 * Constructs and initializes the variables in the bank account class, as well
	 * as the fee
	 * 
	 * @param balance
	 *            The stating account balance
	 * @param accountNumber
	 *            The account number
	 * @param accHolder
	 *            a instance of the class person
	 * @param fee
	 *            The monthly cost of the account
	 * 
	 */
	public ChequingAccount(int accountNumber, Person accHolder, double balance, double fee) {
		super(accountNumber, accHolder, balance);
		this.fee = fee;
		// TODO Auto-generated constructor stub
	}

	/**
	 * The default Constructor used to add account by user inputs
	 */
	public ChequingAccount() {

	}

	/**
	 * This method prints out the fee, also calls the rest of the toString methods
	 * and print all the account information
	 * 
	 * @return printAccount prints all the account info
	 */

	public String toString() {
		// code the prints account info
		String printAccount = "C " + super.toString();
		return printAccount;

	}

	/**
	 * calculates and updates the balance by subtracting the fee if balance is too
	 * low it will tell the user
	 */
	@Override
	public void monthlyAccountUpdate() {
		// code that updates the monthly balance
		balance = balance - fee;

	}

}
