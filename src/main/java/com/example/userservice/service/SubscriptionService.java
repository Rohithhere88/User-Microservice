// src/main/java/com/example/userservice/service/SubscriptionService.java
package com.example.userservice.service;

import com.example.userservice.dto.SubscriptionRequest;
import com.example.userservice.dto.SubscriptionResponse;
import com.example.userservice.entity.Subscription;
import com.example.userservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionResponse create(SubscriptionRequest request) {
        Subscription subscription = Subscription.builder()
                .userId(request.getUserId())
                .planName(request.getPlanName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(request.getIsActive() != null ? request.getIsActive() : true)
                .build();
        subscription = subscriptionRepository.save(subscription);
        return toResponse(subscription);
    }

    public List<SubscriptionResponse> getByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public SubscriptionResponse update(Long subscriptionId, SubscriptionRequest request) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        subscription.setPlanName(request.getPlanName());
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getEndDate());
        subscription.setIsActive(request.getIsActive());
        subscription = subscriptionRepository.save(subscription);
        return toResponse(subscription);
    }

    public void delete(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    public SubscriptionResponse getActiveSubscription(Long userId) {
        return subscriptionRepository.findByUserIdAndIsActiveTrue(userId)
                .map(this::toResponse)
                .orElse(null);
    }

    private SubscriptionResponse toResponse(Subscription subscription) {
        SubscriptionResponse resp = new SubscriptionResponse();
        resp.setSubscriptionId(subscription.getSubscriptionId());
        resp.setUserId(subscription.getUserId());
        resp.setPlanName(subscription.getPlanName());
        resp.setStartDate(subscription.getStartDate());
        resp.setEndDate(subscription.getEndDate());
        resp.setIsActive(subscription.getIsActive());
        return resp;
    }
}