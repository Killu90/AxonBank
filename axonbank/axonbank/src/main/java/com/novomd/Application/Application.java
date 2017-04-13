package com.novomd.Application;

import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;

import Aggregate.AccountAggregate;
import Commands.CreateAccountCommand;
import Commands.WithdrawMoneyCommand;
import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

public class Application {

	public static void main(String[] args) {

		Configuration config = DefaultConfigurer.defaultConfiguration()
				.configureAggregate(AccountAggregate.class)
				.configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine())
				//.configureCommandBus(c -> new AsynchronousCommandBus())
				.buildConfiguration();

		config.start();
		config.commandBus().dispatch(asCommandMessage(new CreateAccountCommand("4231", 500)));
		config.commandBus().dispatch(asCommandMessage(new WithdrawMoneyCommand("4231", 250)));
		
		//28:37
	}

}
