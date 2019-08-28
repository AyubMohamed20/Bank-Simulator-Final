/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 9
*Date: April 17th, 2019
*/
/**
 * This class is a type of bank account, where money accumulates over time.
 * Extends the bank account class The class calculates and updates the balance
 * adding the money earned from interest. Also, the class prints out the savings
 * account info
 * 
 * @author Ayub Mohamed
 * @version 1.8
 * @since 1.0
 *
 */
public class SavingsAccount extends BankAccount {

	// the interest rate between 0 - 1,
	private double interestRate;
	// lowest balance possible for an account
	private double minimumBalance;
	
	/**
	 * Constructs and initializes the variables in the bank account class, as
	 * well as the minimum balance and the interest rate
	 * 
	 * @param balance
	 *            The stating account balance
	 * @param accountNumber
	 *            The account number
	 * @param accHolder
	 *            a instance of the class person
	 * @param minimumBalance
	 *            the minimum balance in a savings account
	 * @param interestRate
	 *            the interest rate
	 */
	public SavingsAccount(int accountNumber, Person accHolder, double balance, double minimumBalance,
			double interestRate) {
		super(accountNumber, accHolder, balance);
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
	
	}
	/**
	 * The default Constructor used to add account by user inputs
	 */
	public SavingsAccount() {

	}

	/**
	 * This method prints out the minimum balance and the interest rate, also calls
	 * the rest of the toString methods and print all the account information
	 * 
	 * @return printAccount prints all the account info
	 */

	public String toString() {
		// code that prints all account
		String printAccount = "S " + super.toString();
		return printAccount;

	}


	/**
	 * calculates and updates the balance by adding the interest that was earned if
	 * balance is too low it will tell the user
	 */

	@Override
	public void monthlyAccountUpdate() {

			balance = balance * (interestRate) + balance;

	}

}
