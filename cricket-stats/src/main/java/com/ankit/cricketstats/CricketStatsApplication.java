package com.ankit.cricketstats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class CricketStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketStatsApplication.class, args);
	}

}
