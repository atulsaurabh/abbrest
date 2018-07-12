package com.suyojan.abbrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AbbrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbbrestApplication.class, args);
	}
}
