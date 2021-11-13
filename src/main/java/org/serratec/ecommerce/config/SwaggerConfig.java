package org.serratec.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() 
				.apis(RequestHandlerSelectors.basePackage("org.serratec.ecomerce"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.apiInfo());
	}
	
	public ApiInfo apiInfo() {
		ApiInfo apiInfo = 
				new ApiInfoBuilder()
				.title("Ecomerce API")
				.description("Esta é a Api da matéria de RestApi")
				.license("Serratec Version")
				.version("V.1")
				.contact(new Contact("Serratec", "http://www.serratec.org", "flavia@serratec.org"))
				.build();
		
		return apiInfo;
	}
	

}
