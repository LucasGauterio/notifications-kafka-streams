package com.cvccorp.notifications.notifications;

import java.util.Optional;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;
import reactor.core.publisher.Flux;

import reactor.core.publisher.UnicastProcessor;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import com.cvccorp.notifications.notifications.common.dto.Configuration;
import com.cvccorp.notifications.notifications.common.dto.RequestMessage;

@Slf4j
@SpringBootApplication
public class CorpNotificationsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorpNotificationsApiApplication.class, args);
    }

    private static final String EMAIL_CHANNEL = "email";
    private static final String WHATSAPP_CHANNEL = "whatsapp";

    @Bean
    public Function<Flux<RequestMessage>,Tuple2<Flux<RequestMessage>, Flux<RequestMessage>>> dispatcher() {
        return flux -> {
           var connectedFlux = flux.publish().autoConnect(2);
            //TODO remove UnicastProcessor
            UnicastProcessor email = UnicastProcessor.create();
            UnicastProcessor whatsapp = UnicastProcessor.create();
            var emailFlux = connectedFlux.filter(channelFilter(EMAIL_CHANNEL))
                    .doOnNext(email::onNext);
            var whatsappFlux = connectedFlux.filter(channelFilter(WHATSAPP_CHANNEL))
                    .doOnNext(whatsapp::onNext);

           return Tuples.of(Flux.from(emailFlux).doOnSubscribe(subscription -> emailFlux.subscribe()),
                   Flux.from(whatsappFlux).doOnSubscribe(subscription -> whatsappFlux.subscribe()));
        };
    }


    private static Predicate<RequestMessage> channelFilter(String channel) {
        return requestMessage -> Optional.ofNullable(requestMessage.getConfiguration())
                .map(Configuration::getChannels)
                .map(strings -> strings.stream().anyMatch(o -> o.getType().equalsIgnoreCase(channel)))
                .orElse(false);

    }


}