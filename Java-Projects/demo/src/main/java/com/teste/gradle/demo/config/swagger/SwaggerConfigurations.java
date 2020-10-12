package com.teste.gradle.demo.config.swagger;

import java.util.Arrays;

import com.teste.gradle.demo.modelo.Usuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
  
  @Bean
  public Docket demoApi(){
    return new Docket(DocumentationType.SWAGGER_2)
    .select()
    .apis(RequestHandlerSelectors.basePackage("com.teste.gradle.demo"))
    .paths(PathSelectors.ant("/**"))
    .build()
    .ignoredParameterTypes(Usuario.class)
    .globalOperationParameters(
            Arrays.asList(
                    new ParameterBuilder()
                        .name("Authorization")
                        .description("Header para Token JWT")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .build()));
  }
  //* URL = LOCALHOST:8080/swagger-ui.html *//
}