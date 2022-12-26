package com.hanslv.web.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : hansLv
 * @date : 2022/12/26 14:26
 */
@SpringBootApplication
public class WebChatStarter {
    public static void main(String[] args) {
        new SpringApplication(WebChatStarter.class).run(args);
    }
}
