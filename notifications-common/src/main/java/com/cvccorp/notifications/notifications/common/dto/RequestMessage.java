package com.cvccorp.notifications.notifications.common.dto;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMessage {

    private String producer;

    private Notification notification;

    private Configuration configuration;

    private String content;

    private HashMap<String, String> channelStatusMap;

}
