// src/main/java/com/example/userservice/repository/UserConnectionRepository.java
package com.example.userservice.repository;

import com.example.userservice.entity.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {
    List<UserConnection> findByUserId(Long userId);
    List<UserConnection> findByConnectedUserId(Long connectedUserId);
    Optional<UserConnection> findByUserIdAndConnectedUserId(Long userId, Long connectedUserId);
}