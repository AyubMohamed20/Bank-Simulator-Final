import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 9
*Date: April 17th, 2019
*/
/**
 * This class launches and creates the GUI
 * 
 * @author Ayub Mohamed
 * @version 1.0
 * @since 1.8
 */
public class Assign2 {

	/**
	 * instance of the class bank and it is used to communicate with the GUI
	 */
	Bank bank = new Bank();

	private JFrame frmLab;
	private JTextArea printedAccountsTextArea;
	private JTextField savingsCheckingsTextField;
	private JTextField accountNumberTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField openingBalanceTextField;
	private JTextField enterAccountNumberTextField;
	private JTextField displayAccountTextField;
	private JTextField updateAccountNumberTextField;
	private JTextField balanceTextField;
	private JTextField amountTextField;
	private JPanel addAccountPanel;
	private JPanel displayAccountPanel;
	private JPanel mainMenuPanel;
	private JPanel updateAccountPanel;
	private JPanel printAllAccountPanel;
	private JLabel successfulMessageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assign2 window = new Assign2();
					window.frmLab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Assign2() {
		frmLab = new JFrame();
		frmLab.setTitle("Lab 9 - OOP");
		frmLab.setBounds(100, 100, 560, 430);
		frmLab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLab.getContentPane().setLayout(new CardLayout(0, 0));

		mainMenuPanel = new JPanel();
		frmLab.getContentPane().add(mainMenuPanel, "name_47166236962500");
		mainMenuPanel.setLayout(null);

		JButton addNewAccountButton = new JButton("Add new account");
		addNewAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccountPanel.setVisible(true);
				mainMenuPanel.setVisible(false);

			}
		});
		addNewAccountButton.setBounds(15, 121, 209, 29);
		mainMenuPanel.add(addNewAccountButton);

		JButton updateAccountButton = new JButton("Update an Account");
		updateAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAccountPanel.setVisible(true);
				mainMenuPanel.setVisible(false);
			}
		});
		updateAccountButton.setBounds(269, 121, 254, 29);
		mainMenuPanel.add(updateAccountButton);

		JButton displayAccountButton = new JButton("Diplay an account");
		displayAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAccountPanel.setVisible(true);
				mainMenuPanel.setVisible(false);
			}
		});
		displayAccountButton.setBounds(15, 179, 209, 29);
		mainMenuPanel.add(displayAccountButton);

		JButton printAllAccoutnsButton = new JButton("Print all accounts");
		printAllAccoutnsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAllAccountPanel.setVisible(true);
				mainMenuPanel.setVisible(false);
			}
		});
		printAllAccoutnsButton.setBounds(269, 179, 254, 29);
		mainMenuPanel.add(printAllAccoutnsButton);

		JButton monthlyUpdateButton = new JButton("Run monthly updates");
		monthlyUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.monthlyUpdate();
				successfulMessageLabel.setText("Monthly Update Successful");
			}
		});
		monthlyUpdateButton.setBounds(15, 234, 209, 29);
		mainMenuPanel.add(monthlyUpdateButton);

		JButton accountFromFileButton = new JButton("Add Accounts from text file");
		accountFromFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.readRecord();
				successfulMessageLabel.setText("Accounts from file successfully added from text file" + "");
			}
		});
		accountFromFileButton.setBounds(269, 234, 254, 29);
		mainMenuPanel.add(accountFromFileButton);

		JLabel WelcomeToBankLabel = new JLabel("Welcome to Bank Algonquin");
		WelcomeToBankLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		WelcomeToBankLabel.setBounds(72, 31, 466, 39);
		mainMenuPanel.add(WelcomeToBankLabel);

		JLabel PleaseClickLabel = new JLabel("Please Click on one of the following options");
		PleaseClickLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PleaseClickLabel.setBounds(94, 73, 429, 20);
		mainMenuPanel.add(PleaseClickLabel);

		successfulMessageLabel = new JLabel("");
		successfulMessageLabel.setBounds(29, 320, 482, 20);
		mainMenuPanel.add(successfulMessageLabel);

		updateAccountPanel = new JPanel();
		frmLab.getContentPane().add(updateAccountPanel, "name_47168900883000");
		updateAccountPanel.setLayout(null);

		JLabel updateAccountsMenuLabel = new JLabel("Update Accounts Menu");
		updateAccountsMenuLabel.setBounds(187, 30, 170, 20);
		updateAccountPanel.add(updateAccountsMenuLabel);

		JLabel enterAccountNumberLabel = new JLabel("Enter Account Number: ");
		enterAccountNumberLabel.setBounds(48, 69, 197, 20);
		updateAccountPanel.add(enterAccountNumberLabel);

		updateAccountNumberTextField = new JTextField();
		updateAccountNumberTextField.setBounds(260, 66, 244, 26);
		updateAccountPanel.add(updateAccountNumberTextField);
		updateAccountNumberTextField.setColumns(10);

		balanceTextField = new JTextField();
		balanceTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		balanceTextField.setBounds(15, 175, 493, 125);
		updateAccountPanel.add(balanceTextField);
		balanceTextField.setColumns(10);

		JButton updateAccount = new JButton("Update Account");
		updateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (bank.accounts.size() > 0) {

						int accountNum = Integer.parseInt(updateAccountNumberTextField.getText());
						double updateAmount = Double.parseDouble(amountTextField.getText());

						for (int i = 0; i < bank.accounts.size(); i++) {
							// loops until account number enter matches account number created
							if (bank.accounts.get(i).accountNumber == accountNum) {

								bank.updateAccount(accountNum, updateAmount);
								balanceTextField.setText("Account " + accountNum + " was successfully updated");

								updateAccountNumberTextField.setText("");
								amountTextField.setText("");
							} else {
								balanceTextField.setText("Account Number Entered does not Exist");
							}
						}

					} else {
						balanceTextField.setText("No Account exsit yet");
					}

				} catch (Exception ex) {
					String message = ex.getMessage();
					balanceTextField.setText("ERROR: invalid entry - " + message);

				}

			}
		});
		updateAccount.setBounds(48, 317, 170, 29);
		updateAccountPanel.add(updateAccount);

		JButton updateAccountMainMenuButton = new JButton("Main Menu");
		updateAccountMainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAccountPanel.setVisible(false);
				mainMenuPanel.setVisible(true);

			}
		});
		updateAccountMainMenuButton.setBounds(316, 317, 132, 29);
		updateAccountPanel.add(updateAccountMainMenuButton);

		JLabel enterUpdateAmountLabel = new JLabel("Enter amount to deposit/withdraw: ");
		enterUpdateAmountLabel.setBounds(48, 108, 253, 31);
		updateAccountPanel.add(enterUpdateAmountLabel);

		JLabel postiveOrNegtiveLabel = new JLabel(" (postive number to deposit, negtive number to withdraw)");
		postiveOrNegtiveLabel.setBounds(41, 139, 418, 20);
		updateAccountPanel.add(postiveOrNegtiveLabel);

		amountTextField = new JTextField();
		amountTextField.setBounds(307, 108, 197, 26);
		updateAccountPanel.add(amountTextField);
		amountTextField.setColumns(10);

		displayAccountPanel = new JPanel();
		frmLab.getContentPane().add(displayAccountPanel, "name_47187182928500");
		displayAccountPanel.setLayout(null);

		enterAccountNumberTextField = new JTextField();
		enterAccountNumberTextField.setBounds(258, 75, 245, 26);
		displayAccountPanel.add(enterAccountNumberTextField);
		enterAccountNumberTextField.setColumns(10);

		JLabel enterTheAccountLabel = new JLabel("Enter Account Number: ");
		enterTheAccountLabel.setBounds(47, 78, 175, 20);
		displayAccountPanel.add(enterTheAccountLabel);

		JLabel displayAccountMenuLabel = new JLabel("Display Account Menu");
		displayAccountMenuLabel.setBounds(172, 31, 156, 20);
		displayAccountPanel.add(displayAccountMenuLabel);

		displayAccountTextField = new JTextField();
		displayAccountTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		displayAccountTextField.setBounds(15, 130, 508, 172);
		displayAccountPanel.add(displayAccountTextField);
		displayAccountTextField.setColumns(10);

		JButton displayMainMenuButton = new JButton("Main Menu");
		displayMainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAccountPanel.setVisible(false);
				mainMenuPanel.setVisible(true);
			}
		});
		displayMainMenuButton.setBounds(337, 329, 115, 29);
		displayAccountPanel.add(displayMainMenuButton);

		JButton displayButton = new JButton("Display Account");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					if (bank.accounts.size() > 0) {
						int accountNum = Integer.parseInt(enterAccountNumberTextField.getText());
				
						for (int i = 0; i < bank.accounts.size(); i++) {
				
							if (bank.accounts.get(i).accountNumber == accountNum) {

								int x = bank.findAccount(accountNum);
								String print = bank.displayAccount(x);
								displayAccountTextField.setText(print);
								enterAccountNumberTextField.setText("");
								break;

							} else {
								displayAccountTextField.setText("Account Number Entered does not Exist");
							}
						}
					} else {
						displayAccountTextField.setText("No Account exsit yet");
					}
				
				} catch (Exception ex) {
					String message = ex.getMessage();
					displayAccountTextField.setText("ERROR: invalid entry - " + message);

				}

			}

		});
		displayButton.setBounds(73, 329, 156, 29);
		displayAccountPanel.add(displayButton);

		addAccountPanel = new JPanel();
		frmLab.getContentPane().add(addAccountPanel, "name_47189212294000");
		addAccountPanel.setLayout(null);

		JLabel createAnAccountMenu = new JLabel("Create a Bank Account ");
		createAnAccountMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		createAnAccountMenu.setBounds(159, 36, 236, 20);
		addAccountPanel.add(createAnAccountMenu);

		JLabel accountTypeLabel = new JLabel("Enter account type (s for saving, c for checkings):");
		accountTypeLabel.setBounds(15, 76, 361, 20);
		addAccountPanel.add(accountTypeLabel);

		JLabel accountNumber = new JLabel("Enter an account number:");
		accountNumber.setBounds(15, 112, 198, 20);
		addAccountPanel.add(accountNumber);

		JLabel firstNameLabel = new JLabel("Enter the first name of the account holder:");
		firstNameLabel.setBounds(15, 146, 313, 30);
		addAccountPanel.add(firstNameLabel);

		JLabel lastNameLabel = new JLabel("Enter the last name of the account holder:");
		lastNameLabel.setBounds(15, 185, 313, 20);
		addAccountPanel.add(lastNameLabel);

		JLabel emailLabel = new JLabel("Enter the email of the account holder: ");
		emailLabel.setBounds(15, 221, 273, 20);
		addAccountPanel.add(emailLabel);

		JLabel openingBalanceLabel = new JLabel("Enter opening balance: ");
		openingBalanceLabel.setBounds(15, 257, 168, 20);
		addAccountPanel.add(openingBalanceLabel);

		JLabel addAccuntCheckLabel = new JLabel("");
		addAccuntCheckLabel.setBounds(15, 293, 508, 20);
		addAccountPanel.add(addAccuntCheckLabel);

		JButton createNewAccountButton = new JButton("Create New Account");
		createNewAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					int accountNum = Integer.parseInt(accountNumberTextField.getText());
					double balance = Double.parseDouble(openingBalanceTextField.getText());
					String firstName = firstNameTextField.getText();
					String lastName = lastNameTextField.getText();
					String email = emailTextField.getText();
					String accountType = savingsCheckingsTextField.getText();

					if (accountType.equalsIgnoreCase("s") || accountType.equalsIgnoreCase("c")) {
						bank.addAccount(accountType, accountNum, firstName, lastName, email, balance);
						addAccuntCheckLabel.setText("Account Added");

						accountNumberTextField.setText("");
						openingBalanceTextField.setText("");
						firstNameTextField.setText("");
						lastNameTextField.setText("");
						emailTextField.setText("");
						savingsCheckingsTextField.setText("");
					} else {
						addAccuntCheckLabel.setText("ERROR: Account Type must be S or C");
					}

				} catch (Exception e) {
					String message = e.getMessage();
					addAccuntCheckLabel.setText("ERROR " + message);
				}
			}
		});
		createNewAccountButton.setBounds(40, 329, 198, 29);
		addAccountPanel.add(createNewAccountButton);

		savingsCheckingsTextField = new JTextField();
		savingsCheckingsTextField.setBounds(377, 76, 146, 26);
		addAccountPanel.add(savingsCheckingsTextField);
		savingsCheckingsTextField.setColumns(10);

		accountNumberTextField = new JTextField();
		accountNumberTextField.setBounds(206, 109, 317, 26);
		addAccountPanel.add(accountNumberTextField);
		accountNumberTextField.setColumns(10);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(324, 148, 199, 26);
		addAccountPanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(324, 182, 199, 26);
		addAccountPanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		emailTextField = new JTextField();
		emailTextField.setBounds(287, 221, 236, 26);
		addAccountPanel.add(emailTextField);
		emailTextField.setColumns(10);

		openingBalanceTextField = new JTextField();
		openingBalanceTextField.setBounds(182, 254, 341, 26);
		addAccountPanel.add(openingBalanceTextField);
		openingBalanceTextField.setColumns(10);

		JButton addAccMainMenuButton = new JButton("Main Menu ");
		addAccMainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccountPanel.setVisible(false);
				mainMenuPanel.setVisible(true);
			}
		});
		addAccMainMenuButton.setBounds(310, 329, 177, 29);
		addAccountPanel.add(addAccMainMenuButton);

		printAllAccountPanel = new JPanel();
		frmLab.getContentPane().add(printAllAccountPanel, "name_52531006362200");
		printAllAccountPanel.setLayout(null);

		JButton printAccountButton = new JButton("Print Accounts");
		printAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bank.accounts.size() > 0) {
					String x;
					printedAccountsTextArea.setText("");
					for (int i = 0; i < bank.accounts.size(); i++) {
						x = bank.accounts.get(i).toString();
						printedAccountsTextArea.append(x + "\n");
					}
				} else {
					printedAccountsTextArea.setText("No Account exsit yet");
				}
			}
		});
		printAccountButton.setBounds(45, 329, 176, 29);
		printAllAccountPanel.add(printAccountButton);

		JButton printAccountsMainMenuButton = new JButton("Main Menu");
		printAccountsMainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printAllAccountPanel.setVisible(false);
				mainMenuPanel.setVisible(true);
			}
		});
		printAccountsMainMenuButton.setBounds(305, 329, 167, 29);
		printAllAccountPanel.add(printAccountsMainMenuButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 96, 423, 218);
		printAllAccountPanel.add(scrollPane);

		printedAccountsTextArea = new JTextArea();
		printedAccountsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(printedAccountsTextArea);

		JLabel printAllAccountsLabel = new JLabel("Print All Accounts Menu ");
		printAllAccountsLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		printAllAccountsLabel.setBounds(139, 42, 384, 20);
		printAllAccountPanel.add(printAllAccountsLabel);

	}
}
