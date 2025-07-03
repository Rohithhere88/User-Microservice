package com.example.userservice.dto;

import lombok.Data;

@Data
public class UserAddressResponse {
    private Long addressId;
    private Long userId;
    private String label;
    private String address;
    private Boolean isDefault;
}