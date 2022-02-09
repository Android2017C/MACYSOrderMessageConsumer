package com.zensar;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@ComponentScan
public class MacysOrderMessageConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacysOrderMessageConsumerApplication.class, args);
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("MACYSOrderMessageConsumer REST API Documentation", "MACYSOrderMessageConsumer REST APIs released by Zensar Ltd.",
				"2.5", "http://zensar.com/termsofservice",
				new Contact("Srini", "http://srini.com", "sreenivasulu.c@zensar.com"), "GPL", "http://gpl.com",
				new ArrayList<VendorExtension>());
	}
	
	@Bean
	public ModelMapper getModelMapper() {

		return new ModelMapper();
	}
	
	@Bean
	public Docket getCustomizedDocket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.zensar"))
				// .paths(PathSelectors.ant("/advertise/category**")) // /advertise/status
				.paths(PathSelectors.any()).build();
	}

}
