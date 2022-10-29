import java.util.ArrayList;

public class Bank {
	
	private static ArrayList<Account> accounts=new ArrayList<Account>();
	
	public static Account openAccount(String firstName, String lastName, String ssn, String accountName) {
		Customer c=new Customer(firstName,lastName, ssn);
		Account a=new Account(accountName,c);
		accounts.add(a);
		return a;
		
	}
	public static Account lookup(int accountNumber) {
		for (Account a:accounts) {
			if(a.getAccountNumber()==accountNumber)return a;
		}
		return null;	
	}
	
	public static void listAccounts() {
		System.out.println("");
		for (Account a:accounts) {
			System.out.println(a);
		}	
	}
	
	
	
	
	
}
