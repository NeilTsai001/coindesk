package com.cathay.coindesk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoindeskConfig {

	@Value("${coindesk.api.url}")
	private String url;

	public String getUrl() {
		return url;
	}
	
}
