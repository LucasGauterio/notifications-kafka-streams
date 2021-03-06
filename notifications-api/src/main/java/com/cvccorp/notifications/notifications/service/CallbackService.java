package com.cvccorp.notifications.notifications.service;

import com.cvccorp.notifications.notifications.common.dto.RequestMessage;
import com.cvccorp.notifications.notifications.common.dto.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CallbackService {

    public void process(String key, String jsonMessage) {
        try {
            RequestMessage message = new JsonMapper().readValue(jsonMessage, RequestMessage.class);
            ResponseMessage response = new ResponseMessage();
            response.setNotificationId(key);
            //TODO response.setChannelStatusMap(message.getChannelStatusMap());
            log.info("Callback sent to {} {}", message.getConfiguration().getCallbackUrl(), response);
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
