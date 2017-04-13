package Events;


public class MoneyWithdrawnEvent {

	private String accountId;

	private int amount;

	private int balance;

	public MoneyWithdrawnEvent(String accountId, int amount, int balance) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.balance = balance;
	}

	public String getAccountId() {
		return accountId;
	}

	public int getAmount() {
		return amount;
	}

	public int getBalance() {
		return balance;
	}

}
