package com.example.userservice.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserConnectionResponse {
    private Long connectionId;
    private Long userId;
    private Long connectedUserId;
    private String status;
    private Timestamp createdAt;
}