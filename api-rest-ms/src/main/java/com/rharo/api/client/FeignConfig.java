package com.rharo.api.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

/**
 * The Class FeignConfig, contains the configuration for feign client
 */
@Configuration
public class FeignConfig {

	
	@Value("${openfeign.api.user-agent-id.header}")
	private String userAgentIdHeader;	

	@Value("${openfeign.api.user-agent-id.header.code}")
	private String userAgentIdHeaderCode;
	
	/**
	 * Add header to request.
	 *
	 * @return the request
	 */
	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {			
			requestTemplate.header(userAgentIdHeader, userAgentIdHeaderCode);
		};
	}
}