// src/main/java/com/example/userservice/controller/ChatAccessController.java
package com.example.userservice.controller;

import com.example.userservice.dto.ChatAccessRequest;
import com.example.userservice.dto.ChatAccessResponse;
import com.example.userservice.service.ChatAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat-access")
public class ChatAccessController {
    @Autowired
    private ChatAccessService chatAccessService;

    @PostMapping
    public ResponseEntity<ChatAccessResponse> createOrUpdate(@RequestBody ChatAccessRequest request) {
        return ResponseEntity.ok(chatAccessService.createOrUpdate(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ChatAccessResponse> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(chatAccessService.getByUserId(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        chatAccessService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}