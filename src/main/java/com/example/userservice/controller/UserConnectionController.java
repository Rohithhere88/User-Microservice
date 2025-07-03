// src/main/java/com/example/userservice/controller/UserConnectionController.java
package com.example.userservice.controller;

import com.example.userservice.dto.UserConnectionRequest;
import com.example.userservice.dto.UserConnectionResponse;
import com.example.userservice.service.UserConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-connections")
public class UserConnectionController {
    @Autowired
    private UserConnectionService userConnectionService;

    @PostMapping
    public ResponseEntity<UserConnectionResponse> create(@RequestBody UserConnectionRequest request) {
        return ResponseEntity.ok(userConnectionService.create(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserConnectionResponse>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userConnectionService.getByUserId(userId));
    }

    @GetMapping("/connected-user/{connectedUserId}")
    public ResponseEntity<List<UserConnectionResponse>> getByConnectedUserId(@PathVariable Long connectedUserId) {
        return ResponseEntity.ok(userConnectionService.getByConnectedUserId(connectedUserId));
    }

    @PutMapping("/{connectionId}/status")
    public ResponseEntity<UserConnectionResponse> updateStatus(@PathVariable Long connectionId, @RequestParam String status) {
        return ResponseEntity.ok(userConnectionService.updateStatus(connectionId, status));
    }

    @DeleteMapping("/{connectionId}")
    public ResponseEntity<Void> delete(@PathVariable Long connectionId) {
        userConnectionService.delete(connectionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/between")
    public ResponseEntity<UserConnectionResponse> getConnection(
            @RequestParam Long userId,
            @RequestParam Long connectedUserId) {
        return ResponseEntity.ok(userConnectionService.getConnection(userId, connectedUserId));
    }
}