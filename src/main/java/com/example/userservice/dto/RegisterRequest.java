// src/main/java/com/example/userservice/dto/RegisterRequest.java
package com.example.userservice.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String address;
    private String profilePictureUrl;
    private String bio;
}