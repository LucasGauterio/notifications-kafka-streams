package com.cvccorp.notifications.notifications.config;

import com.cvccorp.notifications.notifications.service.CallbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class Messaging {

    private final CallbackService service;

    public Messaging(CallbackService service) {
        this.service = service;
    }



}
