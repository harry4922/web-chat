package com.hanslv.webchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Starter {
	public static void main(String[] args) {
		new SpringApplication(Starter.class).run(args);
	}
}
