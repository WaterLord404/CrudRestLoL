package com.LeagueOfLegends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = {"com.LeagueOfLegends"})
public class LeagueOfLegendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueOfLegendsApplication.class, args);
	}

}
