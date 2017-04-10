package com.novomd.sample;


public class CreateAccountCommand {

	private String acountId;

	private int overdraftLimit;

	public CreateAccountCommand(String acountId, int overdraftLimit) {
		super();
		this.acountId = acountId;
		this.overdraftLimit = overdraftLimit;
	}

	public String getAcountId() {
		return acountId;
	}

	public int getOverdraftLimit() {
		return overdraftLimit;
	}

}
