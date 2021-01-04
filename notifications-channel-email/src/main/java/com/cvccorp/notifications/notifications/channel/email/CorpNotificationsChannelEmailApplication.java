package com.cvccorp.notifications.notifications.channel.email;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import com.cvccorp.notifications.notifications.channel.email.service.EmailService;
import com.cvccorp.notifications.notifications.common.dto.RequestMessage;

@SpringBootApplication
public class CorpNotificationsChannelEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorpNotificationsChannelEmailApplication.class, args);
	}

	@Bean
	public Function<Flux<RequestMessage>, Flux<RequestMessage>> sendEmail(EmailService emailService){
		return flux -> flux.map(emailService::process);
	}

}
