package BankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		List<String[]> AccountHoldersData=Utilities.CSV.readFile("F:\\CS F213 (OBJECT ORIENTED PROG)\\Lab material\\Eclipse codes\\Hello World\\src\\BankAccountApp\\NewBankAccounts.csv");
		List<Account> account=new LinkedList<Account>();
		for(String[] AccountHolder: AccountHoldersData)
		{
			String name=AccountHolder[0];
			String SSN=AccountHolder[1];
			String AccountType=AccountHolder[2];
			
			//The Double.parseDouble method below is used to convert String to double.
			double initDeposit=Double.parseDouble(AccountHolder[3]);

			if(AccountType.equals("Savings"))
			{
				account.add(new SavingsAccount(name,SSN,initDeposit));
			}
			else if(AccountType.equals("Checking"))
			{
				account.add(new CheckingAccount(name,SSN,initDeposit));
			}
			else
			{
				System.out.println("Error reading the account type");
			}
		}
		
		for(Account acc:account)
		{
			System.out.println("\n***************");
			acc.ShowInfo();
		}

	}

}
