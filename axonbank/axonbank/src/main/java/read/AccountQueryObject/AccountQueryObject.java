package read.AccountQueryObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountQueryObject {

	@Id
	private String acountId;

	private int overdraftLimit;

	public AccountQueryObject(String acountId, int overdraftLimit) {
		super();
		this.acountId = acountId;
		this.overdraftLimit = overdraftLimit;
	}

	public AccountQueryObject() {

	}

	public String getAcountId() {
		return acountId;
	}

	public int getOverdraftLimit() {
		return overdraftLimit;
	}
}
