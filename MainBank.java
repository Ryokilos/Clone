
public class MainBank {

	public static void main(String[] args) {

		Account acc;
		int option = 0;
		do {
			option = UIManager.getMainOption();

			switch (option) {
			case 1:

				UIManager.print(UIManager.MSG_ACCOUNT_OPENED,
						new Object[] { Bank.openAccount(UIManager.readString(UIManager.MSG_FIRST_NAME),
								UIManager.readString(UIManager.MSG_LAST_NAME), UIManager.readString(UIManager.MSG_SSN),
								UIManager.readString(UIManager.MSG_ACCOUNT_NAME)).getAccountNumber() });
				break;
			case 2:
				Bank.listAccounts();
				break;

			case 3:
				acc = findAccount();
				if (acc != null) {
					printAccountAction(acc.deposit(UIManager.readDouble(UIManager.MSG_AMOUNT)), "Deposit", acc);
				}
				break;
			case 4:
				acc = findAccount();
				if (acc != null) {
					printAccountAction(acc.withdraw(UIManager.readDouble(UIManager.MSG_AMOUNT)), "Withdrawal", acc);
				}
				break;

			case 5:
				acc = findAccount();
				if (acc != null) {
					acc.close();
					UIManager.print(UIManager.MSG_ACCOUNT_CLOSED,new Object[] {acc.getAccountNumber(),acc.getBalance()});

				}
			}

		} while (option != 6);

	}

	// Print success / failure messages for deposit and withdrawal
	private static void printAccountAction(boolean outcome, String actionType, Account ac) {
		if (outcome)
			UIManager.print(UIManager.MSG_ACCOUNT_ACTION, new Object[] { actionType, "successful", ac.getBalance() });
		else
			UIManager.print(UIManager.MSG_ACCOUNT_ACTION, new Object[] { actionType, "unsuccessful", ac.getBalance() });
	}

	// Find an account
	private static Account findAccount() {
		int aNumber = UIManager.readInt(UIManager.MSG_ACCOUNT_NUMBER);
		Account acc = Bank.lookup(aNumber);
		if (acc == null)
			UIManager.print(UIManager.MSG_ACCOUNT_NOT_FOUND, new Object[] { aNumber });
		return acc;

	}

}
