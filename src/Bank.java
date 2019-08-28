import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 9
*Date: April 17th, 2019
*/
/**
 * This class declares, instantiates and initializes the bank accounts. The
 * class also calculates, updates and prints each account as well as prints out
 * all the account information such fee, interest rate, and the balance
 * 
 * @author Ayub Mohamed
 * @version 1.8
 * @since 1.0
 *
 */
public class Bank {

	private Scanner input;

	// creating the arraylist of account
	protected ArrayList<BankAccount> accounts;

	/**
	 * Constructs and initializes bank accounts array using arraylist
	 * 
	 */
	public Bank() {

		accounts = new ArrayList<BankAccount>();

	}

	/**
	 * Gets user inputs from GUi and creates and bank account also, this method assign random value
	 * for the savings accounts interest rate and the chequings account fee
	 * @param accountType, the user chooses savings or checking's
	 * @param accountnNum, the account number enter by the user
	 * @param firstName, the first name of the user account
	 * @param lastname, the last name of the user account
	 * @param email, email of the account
	 * @param balance, opening balance of the account
	 */
	public void addAccount(String accountType, int accountNum, String firstName, String lastName, String email,
			double balance) {

		Person accHolder = new Person(firstName, lastName, email);

		if (accountType.equalsIgnoreCase("c")) {
			double fee;
			// Calculates a random fee for the accounts
			do {
				fee = (double) (Math.random() * 100);
			} while (fee < 5 || fee > 10);

			// creates a new chequing account and stores into array list
			ChequingAccount x = new ChequingAccount(accountNum, accHolder, balance, fee);
			accounts.add(x);

		}
		if (accountType.equalsIgnoreCase("s")) {
			double interestRate;
			// Calculates a random interest rate for the account
			do {
				interestRate = (double) (Math.random());
			} while (interestRate < 0 || interestRate > 0.1);

			// creates a new savings account and stores into array list
			SavingsAccount x = new SavingsAccount(accountNum, accHolder, balance, 0, interestRate);
			accounts.add(x);

		}
	}

	/**
	 * This method will check if the user entered a valid account number, if no
	 * account exist it will return -1
	 * 
	 * @return checkAccount return the value that matches the account number entered
	 * @param accountNum, the account number enter by the user
	 */

	public int findAccount(int accountNum) {

		int checkAccount = -1;

		for (int i = 0; i < accounts.size(); i++) {
			// loops until account number enter matches account number created
			if (accounts.get(i).accountNumber == accountNum) {

				return checkAccount = i;

			}
		}
		return checkAccount;
	}

	/**
	 * This method calls the find account method, and update the account accordingly
	 * 
	 * @param accountNum, the account number enter by the user
	 * @param amount, the amount the user to add or subtract
	 */

	public void updateAccount(int accountNum, double amount) {

		int x = findAccount(accountNum);

		if (x > -1) {

			accounts.get(x).updateBalance(amount);

		}
	}

	/**
	 * This methods gets the account number inputed by the user and displays all the account information 
	 * @return print, it will return as String so it can be outputted to the GUI
	 * 
	 * @param accountNum, This account number entered by the user
	 * 
	 */
	public String displayAccount(int accountNum) {

		String print = accounts.get(accountNum).toString();
		return print;

	}

	/**
	 * This method Print out all the accounts
	 * @return print, it will return as String so all the accounts can be outputted to the GUI
	 */

	public String printAccountDetails() {

		String print = null;

		// code that prints all account
		for (int i = 0; i < accounts.size(); i++) {
			print = accounts.get(i).toString();
		}

		return print;

	}

	/**
	 * This method update all accounts
	 */

	public void monthlyUpdate() {

		for (int i = 0; i < accounts.size(); i++) {
			accounts.get(i).monthlyAccountUpdate();

		}

	}

	/**
	 * This method opens the file bankinput.txt
	 * 
	 * @throws FileNotFoundException
	 *             if unable to locate the file
	 */
	public void openInputFile() {

		File file = new File("bankData.txt");
		// code to open file
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Error: " + ex);

		}

	}

	/**
	 * This method closes the input file
	 */
	public void closeInputFile() {
		// code the close file
		input.close();
	}

	/**
	 * This method read the input file, uses the date to create an account and
	 * stores the accounts into the array list
	 */
	public void readRecord() {

		openInputFile();

		while (input.hasNext()) {

			// store the data from file to the variables below
			String accountType = input.next();
			int accountNumber = input.nextInt();
			String firstName = input.next();
			String lastName = input.next();
			double phoneNumber = input.nextDouble();
			String email = input.next();
			double balance = input.nextDouble();

			Person accHolder = new Person(firstName, lastName, email);

			if (accountType.equalsIgnoreCase("c")) {
				double fee;
				// Calculates a random fee for the accounts
				do {
					fee = (double) (Math.random() * 100);
				} while (fee < 5 || fee > 10);

				// creates a new chequing account and stores into array list
				ChequingAccount x = new ChequingAccount(accountNumber, accHolder, balance, fee);
				accounts.add(x);

			}
			if (accountType.equalsIgnoreCase("s")) {
				double interestRate;
				// Calculates a random interest rate for the account
				do {
					interestRate = (double) (Math.random());
				} while (interestRate < 0 || interestRate > 0.1);

				// creates a new savings account and stores into array list
				SavingsAccount x = new SavingsAccount(accountNumber, accHolder, balance, 0, interestRate);
				accounts.add(x);

			}

		}
		closeInputFile();

	}

}
