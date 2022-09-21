package com.mohit.springboot.learn.spring.boot.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service") // it is a confiration of properties
@Component // we want spring to manage this : search for CurrenyConfisurations.class for Autowiring
public class CurrecyConfigurations {

	private String url;
	private String username;
	private String key;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
