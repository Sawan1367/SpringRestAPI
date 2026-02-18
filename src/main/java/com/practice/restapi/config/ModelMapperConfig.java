package com.practice.restapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	/**
	 * It monitors the fields to convert the data from java object to db entities
	 * @return
	 */
    @Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
