package com.novomd.sample;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import com.novomd.Exception.OverdraftLimitExceedsException;

import Aggregate.AccountAggregate;
import Commands.CreateAccountCommand;
import Commands.WithdrawMoneyCommand;
import Events.AccountCreateEvent;
import Events.MoneyWithdrawnEvent;


public class AccountTest1 {

	private FixtureConfiguration<AccountAggregate> fixture;

	@Before
	public void setUp() {
		fixture = Fixtures.newGivenWhenThenFixture(AccountAggregate.class);
	}

	@Test
	public void testAccountEventCreated() {
		fixture.givenNoPriorActivity().when(new CreateAccountCommand("1234", 1000))
				.expectEvents(new AccountCreateEvent("1234", 1000));
	}

	@Test
	public void testWithdrawReasonableAmount() {
		fixture.given(new AccountCreateEvent("1234", 1000)).when(new WithdrawMoneyCommand("1234", 600))
				.expectEvents(new MoneyWithdrawnEvent("1234", 600, -600));
	}

	@Test
	public void testWithdrawAbsurdAmount() {
		fixture.given(new AccountCreateEvent("1234", 1000)).when(new WithdrawMoneyCommand("1234", 1001))
				.expectException(OverdraftLimitExceedsException.class);

	}

	@Test
	public void testWithdrawTwice() {

		fixture.given(new AccountCreateEvent("1234", 1000), new MoneyWithdrawnEvent("1234", 999, -999))
				.when(new WithdrawMoneyCommand("1234", 2))
				.expectException(OverdraftLimitExceedsException.class);
	}

}
