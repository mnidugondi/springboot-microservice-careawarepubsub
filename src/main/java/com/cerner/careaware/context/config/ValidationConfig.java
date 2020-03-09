package com.cerner.careaware.context.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.cerner.ibus.cfc.eligibility.validation" })
public class ValidationConfig {

}
