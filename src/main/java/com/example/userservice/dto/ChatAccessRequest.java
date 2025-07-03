package com.example.userservice.dto;

import lombok.Data;

@Data
public class ChatAccessRequest {
    private Long userId;
    private Boolean canChat;
}