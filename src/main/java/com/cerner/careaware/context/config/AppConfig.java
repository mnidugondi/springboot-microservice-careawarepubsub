package com.cerner.careaware.context.config;

import static com.cerner.careaware.CfcServiceConstants.CONNECTION_TIMEOUT;
import static com.cerner.careaware.CfcServiceConstants.READ_TIMEOUT;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.cerner.careaware.context.config.ValidationConfig;
import com.cerner.careaware.persistence.config.JPAConfig;
import com.google.gson.Gson;

@Configuration
@Import ({JPAConfig.class
		 ,ValidationConfig.class})
@ComponentScan(basePackages = {"com.cerner.ibus.cfc.eligibility.service","com.cerner.ibus.cfc.eligibility.mapper",
		"com.cerner.ibus.cfc.eligibility.discrepancy.service","com.cerner.ibus.cfc.eligibility.logger",
		"com.cerner.ibus.cfc.eligibility.util", "com.cerner.ibus.cfc.eligibility.update.service",
		"com.cerner.ibus.cfc.eligibility.readiness.service"})
public class AppConfig {
	
	@Bean
 	RestTemplate restTemplate() {
 		RestTemplate restTemplate = new RestTemplateBuilder()
 				.setConnectTimeout(CONNECTION_TIMEOUT)
 				.setReadTimeout(READ_TIMEOUT)
 				.build();
 		Gson gson = new Gson();
 		GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
 		gsonHttpMessageConverter.setGson(gson);
 		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
 		messageConverters.add(gsonHttpMessageConverter);
 		restTemplate.setMessageConverters(messageConverters);
 		return restTemplate;
 	}
}
