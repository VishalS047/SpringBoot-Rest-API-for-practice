package com.rest.api.restapis;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


@SpringBootApplication
public class RestapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapisApplication.class, args);
	}

	@Bean
	public AcceptHeaderLocaleResolver localeResolver() { 
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	// @Bean
	// public MessageSource messageSource () {
	// 	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	// 	messageSource.setBasename("messages");
	// 	return messageSource;
	// }
}
	