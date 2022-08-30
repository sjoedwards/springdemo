package com.sjoedwards.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.sjoedwards.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// define bean for our sad fortune service
	// Actual bean ID that will be used when assigned to the service is sadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject the dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
