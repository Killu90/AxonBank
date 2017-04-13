package Events;


public class AccountCreateEvent {

	private String accountId;

	private int overdraftLimit;

	public AccountCreateEvent(String accountId, int amount) {
		super();
		this.accountId = accountId;
		this.overdraftLimit = amount;

	}

	public String getAccountId() {
		return accountId;
	}

	public int getOverdraftLimit() {
		return overdraftLimit;
	}


}
