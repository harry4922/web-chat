package com.hanslv.web.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author hanslv
 *
 */
@SpringBootApplication
public class WebChatApplication {
	public static void main(String[] args) {
		new SpringApplication(WebChatApplication.class).run(args);
	}
}
