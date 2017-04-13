package Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;


public class WithdrawMoneyCommand {

	@TargetAggregateIdentifier
	private String accountId;

	private int amount;

	public WithdrawMoneyCommand(String withdrawID, int amount) {
		super();
		accountId = withdrawID;
		this.amount = amount;
	}

	public String getWithdrawID() {
		return accountId;
	}

	public int getAmount() {
		return amount;
	}

}
