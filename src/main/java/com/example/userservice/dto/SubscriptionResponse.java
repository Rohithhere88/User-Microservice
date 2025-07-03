package com.example.userservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubscriptionResponse {
    private Long subscriptionId;
    private Long userId;
    private String planName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}