package com.example.userservice.dto;

import lombok.Data;

@Data
public class UserAddressRequest {
    private Long userId;
    private String label;
    private String address;
    private Boolean isDefault;
}