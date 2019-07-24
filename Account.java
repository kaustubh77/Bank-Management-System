package BankAccountApp;

/* We define Account as an abstract class because we don't need to create its object.
 * Saving and Checking account are going to inherit from Accounts class and therefore we will be 
 * creating their objects and not the Account's object.
 * 
 * The IBaseRate is an interface that the Account class implements ie. the IBaseRate is common to both Saving and
 * Checking account and therefore both need to inherit the interest rate. We could have also written the code of 
 * IBaseRate inside the Account class but since the interest rate is coming as input from a separate institution 
 * like for example RBI, we are writing the code of IBaseRate in the interface block. In short, we are binding the 
 * code written by the RBI with our Parent class (the Account class here) and are passing this on to Saving and 
 * Checking account classes.
 */

public abstract class Account implements IBaseRate{
	//List common properties for Saving and Checking account
	
	/* We have kept only those variables as private that we are not using outside the
	 * Accounts class. But for the variables that we are using in the child classes
	 * ie. in the Savings and Checking account class we have kept those variable as 
	 * protected. Protected variables can be accessed in the child class ie. in the same 
	 * package but we should not give access to those variables to the user.
	 */
    private String name;
	protected String AccountNumber;
	private String SSN;
	protected double rate;
	protected double balance;
	private static int index=10000;
	
	//Constructor to set the base properties and initialize the account 
	public Account()
	{
		System.out.println("Please Enter a name in the Account holder Name field");
	}

	public Account(String name,String SSN,double initDeposit) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.SSN=SSN;
		this.balance=initDeposit;
		index++;
		this.AccountNumber=setAccountNumber();
		setRate();
	}
	public void compound()
	{
		double AccruedInterest=balance*(rate/100);
		System.out.println("AccruedInterest: $"+AccruedInterest);
	}
	
	//Since this class implements interface in which we can have an abstract method.
	//Now this abstract method has its signature here but its implementation
	//will be in its subclasses. Both the subclasses can have different implementation
	//for the setRate function which is also what we actually need. Both the 
	//types of accounts will have different interest rates. And then later on 
	//by the virtue of OOP and the common name 'setRate' that we have given 
	//in both the types of accounts we are able to call the setRate method for both of 
	//them through the common parent class.
	public abstract void setRate();
	
	//List common methods
	public void deposit(double amount)
	{
		balance=balance+amount;
		System.out.println("Depositing $"+amount+" to your account");
	}
	public void transfer(String TransferTo,double amount)
	{
		balance=balance-amount;
		System.out.println("Transferring $"+amount+" to " +TransferTo+"'s account");
	}
	public void withdraw(double amount)
	{
		balance=balance-amount;
		System.out.println("Withdrawing $"+amount+" from your account");
	}
	
	private String setAccountNumber()
	{
		String last2ofSSN=this.SSN.substring(SSN.length()-2, SSN.length());
		int UniqueID=index;
		int RandomID=(int)(Math.random()*1000);
		return last2ofSSN+UniqueID+RandomID;
	}
	
	public void ShowInfo()
	{
		System.out.println("New Account created");
		System.out.println("Name of Account Holder: "+name);
		System.out.println("SSN: "+SSN+" \nInitial Deposit: "+balance);
		System.out.println("Rate: "+rate+"%");
	}
}
