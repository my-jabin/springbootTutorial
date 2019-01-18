package com.jiujiu.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("appconfig")
public class AppConfig {

	/*
	 * This is the welcome message
	 */
	private String welcomeMsg = "hello world";

	/*
	 * This is client secret
	 */
	private String clientSecret = "clientSecret";

	public String getWelcomeMsg() {
		return welcomeMsg;
	}

	public void setWelcomeMsg(String welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}
