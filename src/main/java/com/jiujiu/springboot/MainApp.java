package com.jiujiu.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiujiu.springboot.config.AppConfig;
import com.jiujiu.springboot.filter.AppFilter;
import com.jiujiu.springboot.filter.CertainFilter;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
@EnableTransactionManagement
public class MainApp {

	private static final Logger log =  LoggerFactory.getLogger(MainApp.class);


	@Value("${sport.something}")
	private String sport;


	@Autowired
	private AppConfig appConfig ;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public FilterRegistrationBean<CertainFilter> loggingFilter(){
		FilterRegistrationBean<CertainFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new CertainFilter());
		registrationBean.addUrlPatterns("/filter/*");

		return registrationBean;
	}
	
	@Bean
	CommandLineRunner runner() {
			return arg ->{
				System.out.println("welcome " + appConfig.getWelcomeMsg());
				System.out.println(appConfig.getClientSecret());
				System.out.println("Using properties: " + sport);
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
