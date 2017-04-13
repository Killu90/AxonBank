package Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.novomd.Exception.OverdraftLimitExceedsException;

import Commands.CreateAccountCommand;
import Commands.WithdrawMoneyCommand;
import Events.AccountCreateEvent;
import Events.MoneyWithdrawnEvent;

@Aggregate
public class AccountAggregate {

	@AggregateIdentifier
	private String accountId;

	private int balance;
	
	private int overdraftLimit;

	public AccountAggregate() {

	}

	@CommandHandler
	public AccountAggregate(CreateAccountCommand command) {
		apply(new AccountCreateEvent(command.getAcountId(), command.getOverdraftLimit()));
		System.out.println("CreateAccountCommand executed");
	}
	
	@CommandHandler
	public void handle(WithdrawMoneyCommand command) throws OverdraftLimitExceedsException {
		if (balance + overdraftLimit >= command.getAmount()) {
		apply(new MoneyWithdrawnEvent(command.getWithdrawID(), command.getAmount(), balance - command.getAmount()));
		}
		else {
			throw new OverdraftLimitExceedsException();
		}
		System.out.println("CreateAccountCommand executed");
	}

	@EventSourcingHandler
	public void on(AccountCreateEvent event) {
		this.accountId = event.getAccountId();
		this.overdraftLimit = event.getOverdraftLimit();
		System.out.println("Eventhandler executed");
	}
	
	@EventSourcingHandler
	public void on(MoneyWithdrawnEvent event) {
		this.balance = event.getBalance();
		System.out.println("Eventhandler executed");
	}

}
