package com.zensar;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@Configuration
public class ItsTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsTechApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)          
			      .select()                                       
			      .apis(RequestHandlerSelectors.basePackage("com.zensar.controller"))
			      .paths(PathSelectors.any())                     
			      .build();
	}
//	private ApiInfo getApiInfo() {
//	ApiInfo apiInfo=new ApiInfo("Stock Rest Api Documentation",
//	"This page givesRest API Doucmentation ", "2.5",
//	"My Terms of services",
//	new Contact("Prashant Dhoke","http://prashant.com","prashant.dhoke@zensar.com"),
//	"GPL", "http://gpl.org",
//	new ArrayList<VendorExtension>());
//	return apiInfo;
//	}
}
