package com.example.userservice.dto;

import lombok.Data;

@Data
public class UserConnectionRequest {
    private Long userId;
    private Long connectedUserId;
    private String status; // "PENDING", "ACCEPTED", "BLOCKED"
}