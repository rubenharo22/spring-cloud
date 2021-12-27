package com.rharo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig{

	@Bean
	public Docket api(AppProperties appProperties) {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(appProperties.getGroupName())
				.apiInfo(getApiInfo(appProperties))
				.select()
				.apis(RequestHandlerSelectors.basePackage(appProperties.getBasePackage()))
				 .paths(PathSelectors.any())
				.build()
				//Deactivate the code response by default
				.useDefaultResponseMessages(false);
	}

	private ApiInfo getApiInfo(AppProperties appProperties) {
		return new ApiInfoBuilder()
				.title(appProperties.getTitle())
				.description(appProperties.getDescription())
				.licenseUrl(appProperties.getAuthor())
				.version(appProperties.getVersion())
				.build();
	}
}
