// src/main/java/com/example/userservice/service/ChatAccessService.java
package com.example.userservice.service;

import com.example.userservice.dto.ChatAccessRequest;
import com.example.userservice.dto.ChatAccessResponse;
import com.example.userservice.entity.ChatAccess;
import com.example.userservice.repository.ChatAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatAccessService {
    @Autowired
    private ChatAccessRepository chatAccessRepository;

    public ChatAccessResponse createOrUpdate(ChatAccessRequest request) {
        ChatAccess chatAccess = ChatAccess.builder()
                .userId(request.getUserId())
                .canChat(request.getCanChat() != null ? request.getCanChat() : false)
                .build();
        chatAccess = chatAccessRepository.save(chatAccess);
        return toResponse(chatAccess);
    }

    public ChatAccessResponse getByUserId(Long userId) {
        ChatAccess chatAccess = chatAccessRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Chat access not found"));
        return toResponse(chatAccess);
    }

    public void delete(Long userId) {
        chatAccessRepository.deleteById(userId);
    }

    private ChatAccessResponse toResponse(ChatAccess chatAccess) {
        ChatAccessResponse resp = new ChatAccessResponse();
        resp.setUserId(chatAccess.getUserId());
        resp.setCanChat(chatAccess.getCanChat());
        return resp;
    }
}