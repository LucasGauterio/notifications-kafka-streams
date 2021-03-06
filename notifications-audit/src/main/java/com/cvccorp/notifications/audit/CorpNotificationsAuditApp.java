package com.cvccorp.notifications.audit;

import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import com.cvccorp.notifications.audit.services.LoggingService;
import com.cvccorp.notifications.notifications.common.dto.RequestMessage;

@SpringBootApplication
public class CorpNotificationsAuditApp {

    public static void main(String[] args) {
        SpringApplication.run(CorpNotificationsAuditApp.class, args);
    }

    @Bean
    public Consumer<Flux<Message<RequestMessage>>> audit(LoggingService process){
         return flux -> flux.subscribe(process::log);
    }

}
