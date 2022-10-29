
public class Account {
	
	private static int accountNumberCounter=1000;
	
	private String accountName;
	private Customer accountHolder;
	private double balance;
	private boolean open=true;
	private int accountNumber;
	
	public Account(String name, Customer customer) {
		accountName=name;
		accountHolder=customer;
		balance=0.0;
		accountNumber=++accountNumberCounter;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amount) {
		if(isOpen()) {
			balance+=amount;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean withdraw(double amount) {
		if(balance-amount>0) {
			balance-=amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void close() {
		open=false;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public String toString() {
		String aName=accountNumber+"("+accountName+")"+" : "+accountHolder.toString()+ " : "+balance+" : "+(open?"Account Open":"Account Closed");
		return aName;
	}
	
	
	
	
	
	

}
