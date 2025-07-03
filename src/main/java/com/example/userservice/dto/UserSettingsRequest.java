package com.example.userservice.dto;

import lombok.Data;

@Data
public class UserSettingsRequest {
    private Long userId;
    private Boolean allowMessages;
    private Boolean allowProfileSuggestions;
}