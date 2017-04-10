package com.novomd.sample;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

import org.axonframework.commandhandling.AsynchronousCommandBus;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.spring.config.EnableAxonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableAxonAutoConfiguration
@SpringBootApplication
public class AxonbankApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(AxonbankApplication.class, args);
		CommandBus commandBus = config.getBean(CommandBus.class);
		commandBus.dispatch(asCommandMessage(new CreateAccountCommand("4231", 500)));
		commandBus.dispatch(asCommandMessage(new WithdrawMoneyCommand("4231", 250)));
	}

	@Bean
	public EventStorageEngine eventStorageEngine() {
		return new InMemoryEventStorageEngine();
	}
	
//	@Bean
//	public CommandBus commandBus(){
//		return new AsynchronousCommandBus();
//	}

}
