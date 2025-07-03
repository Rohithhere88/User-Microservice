// src/main/java/com/example/userservice/service/UserSettingsService.java
package com.example.userservice.service;

import com.example.userservice.dto.UserSettingsRequest;
import com.example.userservice.dto.UserSettingsResponse;
import com.example.userservice.entity.UserSettings;
import com.example.userservice.repository.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsService {
    @Autowired
    private UserSettingsRepository userSettingsRepository;

    public UserSettingsResponse createOrUpdate(UserSettingsRequest request) {
        UserSettings settings = UserSettings.builder()
                .userId(request.getUserId())
                .allowMessages(request.getAllowMessages() != null ? request.getAllowMessages() : true)
                .allowProfileSuggestions(request.getAllowProfileSuggestions() != null ? request.getAllowProfileSuggestions() : true)
                .build();
        settings = userSettingsRepository.save(settings);
        return toResponse(settings);
    }

    public UserSettingsResponse getByUserId(Long userId) {
        UserSettings settings = userSettingsRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User settings not found"));
        return toResponse(settings);
    }

    private UserSettingsResponse toResponse(UserSettings settings) {
        UserSettingsResponse resp = new UserSettingsResponse();
        resp.setUserId(settings.getUserId());
        resp.setAllowMessages(settings.getAllowMessages());
        resp.setAllowProfileSuggestions(settings.getAllowProfileSuggestions());
        return resp;
    }
}