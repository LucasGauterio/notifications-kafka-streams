package com.cvccorp.notifications.audit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggingService {

    public void log(Object messages){
        log.info("Logging messages {} ",messages.toString());
    }
}
