package com.marriott.eeh.srss.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.marriott.eeh.srss.v1.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndpointsInfo())
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, Arrays.asList(
                        new ResponseBuilder().code("500")
                                .description("500 message").build(),
                        new ResponseBuilder().code("403")
                                .description("Forbidden!!!!!").build(),
                        new ResponseBuilder().code("204")
                                .description("No Content !!!!!").build()
                ));
    }

    /**
     * SwaggerUI information
     * Temp only excluded Model info
     */

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .defaultModelsExpandDepth(-1)
                .build();
    }

    private ApiInfo apiEndpointsInfo() {
        return new ApiInfoBuilder()
                .title("Enterprise Event Hub")
                .version("v1.1.0")
                .description("API Documentation for EEH Service")
                .license("Marriott Licence")
                .licenseUrl("https://mgs.marriott.com/")
                .contact(new Contact("EEH Kafka Platform", "https://mgs.marriott.com/", "eehkafkateam@marriott.com"))
                .build();
    }

}
