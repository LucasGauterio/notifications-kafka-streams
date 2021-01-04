package com.cvccorp.notifications.audit;

import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import com.cvccorp.notifications.audit.services.LoggingService;
import com.cvccorp.notifications.notifications.channel.email.dto.RequestMessage;

@SpringBootApplication
public class CorpNotificationsAuditApp {

    public static void main(String[] args) {
        SpringApplication.run(CorpNotificationsAuditApp.class, args);
    }

    @Bean
    public Consumer<Flux<RequestMessage>> audit(LoggingService process){
         return flux -> flux.subscribe(process::log);
    }

}
