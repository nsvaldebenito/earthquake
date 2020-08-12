package com.earthquake.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;


@Data
@ConfigurationProperties(prefix = "api-earthquake", ignoreUnknownFields = false)
public class ApplicationProperties {
	
	@Value("${dal.earthquake.service.url}")
	private String graphList;

	

	
}
