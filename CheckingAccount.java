package BankAccountApp;

/* CheckingAccount class is inheriting from the Account class and hence we have written "extends"
 * in front of CheckingAccount.
 */

/* Use of super with constructors: super keyword can also be used to access the parent 
 * class constructor. One more important thing is that, ‘super’ can call both parametric
 * as well as non parametric constructors depending upon the situation.
 *  
 * If a constructor does not explicitly invoke a superclass constructor, the Java compiler
 * automatically inserts a call to the no-argument constructor of the superclass.
 * If the superclass does not have a no-argument constructor, you will get a compile-time error. 
 * Object does have such a constructor, so if Object is the only superclass, there is no problem.
 */

public class CheckingAccount extends Account{
	//List common properties for all Checking Accounts
	private int DebitCardNumber;
	private int DebitCardPIN;
	
	//Constructor to initialize settings for Checking Account
	public CheckingAccount(String name,String SSN,double initDeposit)
	{
		super(name,SSN,initDeposit);
		AccountNumber="2"+AccountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate()
	{
		this.rate=getBaseRate()*0.15;
	}
	
	//List common methods for all Checking Accounts
	private void setDebitCard()
	{
		DebitCardNumber=(int) (Math.random()*Math.pow(10, 12));
		DebitCardPIN=(int) (Math.random()*Math.pow(10, 4));
	}
	
	public void ShowInfo()
	{
		super.ShowInfo();//This calls the method of parent class with the same name.
		System.out.println("Account Number: "+AccountNumber);
		System.out.println("Account Type: Checking");
		System.out.println("Debit Card Number: "+DebitCardNumber+"\nDebit Card PIN: "+DebitCardPIN);
		System.out.print("\n");
	}
	
}
