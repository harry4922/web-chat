package com.hanslv.web.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : hansLv
 * @date : 2022/12/26 14:26
 */
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class WebChatStarter {
    public static void main(String[] args) {
        new SpringApplication(WebChatStarter.class).run(args);
    }
}
