package BankAccountApp;

/* Interface is used in Java because multiple inheritance is not available in java.
 * Also since here in our program, we, the backend developers of this application, are not able to decide the interest 
 * rate for the accounts. These are either decided by the RBI or are different from bank to bank. And hence we need 
 * to take the interest rate as input from them ie. we need to provide the RBI an interface
 * to our application to provide their interest rate as input.
 */

/* Before Java 8 interfaces could only have abstract methods. But now using the 
 * default keyword we can create concrete method in an interface. We can also use 
 * static in the place of default. And the specifier for methods in interface cannot be 
 * private, it should either be public or protected.
 */

public interface IBaseRate {
	default double getBaseRate()
	{
		return 2.5;
	}
}
