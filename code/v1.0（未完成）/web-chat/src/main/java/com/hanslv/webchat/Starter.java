package com.hanslv.webchat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Starter {
	public static void main(String[] args) {
		new SpringApplication(Starter.class).run(args);
	}
	
	@Bean("versionMap")
	public Map<String , Integer> versionMap(){
		Map<String , Integer> versionMap = new HashMap<>();
		
		return versionMap;
	}
}
