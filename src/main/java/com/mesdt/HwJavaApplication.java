package com.mesdt;

import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HttpPutFormContentFilter;

@SpringBootApplication
public class HwJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwJavaApplication.class, args);
	}
	@Bean
	public Filter httpPutFormContentFilter() {
		return new HttpPutFormContentFilter();
	}
}
