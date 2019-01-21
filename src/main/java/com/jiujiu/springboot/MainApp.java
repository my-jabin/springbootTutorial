package com.jiujiu.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.jiujiu.springboot.config.AppConfig;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class MainApp {

	private static final Logger log =  LoggerFactory.getLogger(MainApp.class);

	@Autowired
	private AppConfig appConfig ;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
			return arg ->{
				System.out.println("welcome " + appConfig.getWelcomeMsg());
				System.out.println(appConfig.getClientSecret());
			};
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runner2() {
		return arg ->{
			System.out.println("this is only showing in dev profile");
			System.out.println("welcome " + appConfig.getWelcomeMsg());
			System.out.println(appConfig.getClientSecret());
		};
	}
	
	
}
