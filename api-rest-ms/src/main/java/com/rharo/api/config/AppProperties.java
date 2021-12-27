package com.rharo.api.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix = "com.rharo.api", ignoreUnknownFields = false)
@Component
@Slf4j
public class AppProperties {

	@Setter
	@Getter
	private String groupName;
	
	@Setter
	@Getter
	private String basePackage;
	
	@Setter
	@Getter
	private String title;
	
	@Setter
	@Getter
	private String description;
	
	@Setter
	@Getter
	private String version;

	@Setter
	@Getter
	private String author;

	@Setter
	@Getter
	private List<String> serviceList;
	
	

	@PostConstruct
	public void setUp() {

		log.info(new StringBuilder("Version ").append(version).append(" - Author ").append(author).toString());
		
		StringBuilder sBuilder = new StringBuilder();
		serviceList.forEach(service -> sBuilder.append(service).append("|"));
		
		log.info("Available services ".concat(sBuilder.toString()));
	}

}
