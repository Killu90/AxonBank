package com.novomd.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAxonAutoConfiguration
@SpringBootApplication
public class AxonbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonbankApplication.class, args);
	}

	// ConfigurableApplicationContext config = SpringApplication.run(AxonbankApplication.class, args);
	// CommandBus commandBus = config.getBean(CommandBus.class);
	// commandBus.dispatch(asCommandMessage(new CreateAccountCommand("4231", 500)));
	// commandBus.dispatch(asCommandMessage(new WithdrawMoneyCommand("4231", 250)));
	// }
	//
	// @Bean
	// public EventStorageEngine eventStorageEngine() {
	// return new InMemoryEventStorageEngine();
	// }
	
//	@Bean
//	public CommandBus commandBus(){
//		return new AsynchronousCommandBus();
//	}

}
