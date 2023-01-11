package com.hanslv.web.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : hansLv
 * @date : 2022/12/26 14:26
 */
@EnableSwagger2
@Slf4j
@EnableScheduling
@SpringBootApplication
public class WebChatStarter  {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplication(WebChatStarter.class).run(args);
        ConfigurableEnvironment environment = run.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "服务端 '{}' 启动完成! \n\t" +
                        "环境(s): {}\n\t" +
                        "端口:{}"+
                        "\n----------------------------------------------------------",
                environment.getProperty("spring.application.name"),
                environment.getActiveProfiles(),
                environment.getProperty("server.port"));
    }
}
