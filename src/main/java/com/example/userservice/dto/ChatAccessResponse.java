package com.example.userservice.dto;

import lombok.Data;

@Data
public class ChatAccessResponse {
    private Long userId;
    private Boolean canChat;
}