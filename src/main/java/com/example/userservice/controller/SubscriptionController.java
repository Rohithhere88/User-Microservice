// src/main/java/com/example/userservice/controller/SubscriptionController.java
package com.example.userservice.controller;

import com.example.userservice.dto.SubscriptionRequest;
import com.example.userservice.dto.SubscriptionResponse;
import com.example.userservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<SubscriptionResponse> create(@RequestBody SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.create(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SubscriptionResponse>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getByUserId(userId));
    }

    @PutMapping("/{subscriptionId}")
    public ResponseEntity<SubscriptionResponse> update(@PathVariable Long subscriptionId, @RequestBody SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.update(subscriptionId, request));
    }

    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> delete(@PathVariable Long subscriptionId) {
        subscriptionService.delete(subscriptionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/active")
    public ResponseEntity<SubscriptionResponse> getActiveSubscription(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getActiveSubscription(userId));
    }
}