package com.stackroute.muzixapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@ComponentScan
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MuzixappApplication  {

	public static void main(String args[]) {
		SpringApplication.run(MuzixappApplication.class, args);
	}

}