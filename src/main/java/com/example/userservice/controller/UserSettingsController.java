// src/main/java/com/example/userservice/controller/UserSettingsController.java
package com.example.userservice.controller;

import com.example.userservice.dto.UserSettingsRequest;
import com.example.userservice.dto.UserSettingsResponse;
import com.example.userservice.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-settings")
public class UserSettingsController {
    @Autowired
    private UserSettingsService userSettingsService;

    @PostMapping
    public ResponseEntity<UserSettingsResponse> createOrUpdate(@RequestBody UserSettingsRequest request) {
        return ResponseEntity.ok(userSettingsService.createOrUpdate(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserSettingsResponse> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userSettingsService.getByUserId(userId));
    }
}