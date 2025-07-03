package com.example.userservice.dto;

import lombok.Data;

@Data
public class UserSettingsResponse {
    private Long userId;
    private Boolean allowMessages;
    private Boolean allowProfileSuggestions;
}