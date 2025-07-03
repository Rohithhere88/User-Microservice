// src/main/java/com/example/userservice/repository/SubscriptionRepository.java
package com.example.userservice.repository;

import com.example.userservice.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);
    Optional<Subscription> findByUserIdAndIsActiveTrue(Long userId);
}