package com.cvccorp.notifications.audit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.cvccorp.notifications.notifications.common.dto.RequestMessage;

@Service
@Slf4j
public class LoggingService {

    public void log(Message<RequestMessage> message){
        log.info("Logging messages {} ",message.getPayload().toString());
    }
}
