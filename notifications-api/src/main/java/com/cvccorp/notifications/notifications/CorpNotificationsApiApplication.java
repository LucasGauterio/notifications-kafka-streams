package com.cvccorp.notifications.notifications;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@SpringBootApplication
public class CorpNotificationsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorpNotificationsApiApplication.class, args);
    }

    @Bean
    Function<String, Message<String>> processor() {
        return message -> {
            log.info("processor received {}", message);
            return MessageBuilder.withPayload(message)
                    .build();
        };
    }

}
