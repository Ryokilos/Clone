import java.util.Scanner;

public class UIManager {

	public static final String MSG_ACCOUNT_OPENED = "%nAccount opened, account number is: %s%n%n";
	public static final String MSG_ACCOUNT_CLOSED = "%nAccount number %s has been closed, balance is %s. Deposit no longer possible!%n";
	public static final String MSG_ACCOUNT_NOT_FOUND = "%nAccount number %s not found! %n%n";
	public static final String MSG_FIRST_NAME = "Enter first name:  ";
	public static final String MSG_LAST_NAME = "Enter last name:  ";
	public static final String MSG_SSN = "Enter Social Security Number:  ";
	public static final String MSG_ACCOUNT_NAME = "Enter account name:  ";
	public static final String MSG_AMOUNT = "Enter amount: ";
	public static final String MSG_ACCOUNT_NUMBER = "Enter account number: ";
	public static final String MSG_ACCOUNT_ACTION = "%n%s was %s, account balance is:%s%n ";
	public static final String[] menuOptions = { "Open Account%n", "List Accounts%n", "Deposit Funds%n", "Withdraw Funds%n",
			"Close an Account%n", "Exit%n%n" };
	public static final String MSG_PROMPT = "%nEnter choice [1-%d]: ";
	public static final Scanner scanner = new Scanner(System.in);

	public static int getMainOption() {
		int choice = 0;
		int menuIndex=1;
		int totalOptions = menuOptions.length;

		Scanner s = new Scanner(System.in);

		while (true) {
			for (String option : menuOptions)
				System.out.printf((menuIndex++)+" - "+option);

			choice = readInt(String.format(MSG_PROMPT, new Object[] { totalOptions }));
			if (choice > 0 && choice <= totalOptions)
				break;
			else 
				menuIndex=1;
		}
		return choice;
	}

	public static String readString(String msg) {
		print(msg, null);
		return scanner.next();
	}

	public static double readDouble(String msg) {

		while (true) {
			try {
				return Double.parseDouble(readString(msg));
			} catch (Exception e) {
				System.out.println("\nInvalid input, please type a decimal number\n");
			}
		}

	}

	public static int readInt(String msg) {
		while (true) {
			try {
				return Integer.parseInt(readString(msg));
			} catch (Exception e) {
				System.out.println("\nInvalid input, please type an integer\n");
			}
		}

	}

	public static void print(String s, Object[] variables) {
		System.out.print(String.format(s, variables));
	}

}
