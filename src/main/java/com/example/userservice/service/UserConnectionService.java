// src/main/java/com/example/userservice/service/UserConnectionService.java
package com.example.userservice.service;

import com.example.userservice.dto.UserConnectionRequest;
import com.example.userservice.dto.UserConnectionResponse;
import com.example.userservice.entity.UserConnection;
import com.example.userservice.repository.UserConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserConnectionService {
    @Autowired
    private UserConnectionRepository userConnectionRepository;

    public UserConnectionResponse create(UserConnectionRequest request) {
        UserConnection connection = UserConnection.builder()
                .userId(request.getUserId())
                .connectedUserId(request.getConnectedUserId())
                .status(UserConnection.Status.valueOf(request.getStatus() != null ? request.getStatus() : "PENDING"))
                .build();
        connection = userConnectionRepository.save(connection);
        return toResponse(connection);
    }

    public List<UserConnectionResponse> getByUserId(Long userId) {
        return userConnectionRepository.findByUserId(userId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public List<UserConnectionResponse> getByConnectedUserId(Long connectedUserId) {
        return userConnectionRepository.findByConnectedUserId(connectedUserId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public UserConnectionResponse updateStatus(Long connectionId, String status) {
        UserConnection connection = userConnectionRepository.findById(connectionId)
                .orElseThrow(() -> new RuntimeException("Connection not found"));
        connection.setStatus(UserConnection.Status.valueOf(status));
        connection = userConnectionRepository.save(connection);
        return toResponse(connection);
    }

    public void delete(Long connectionId) {
        userConnectionRepository.deleteById(connectionId);
    }

    public UserConnectionResponse getConnection(Long userId, Long connectedUserId) {
        return userConnectionRepository.findByUserIdAndConnectedUserId(userId, connectedUserId)
                .map(this::toResponse)
                .orElse(null);
    }

    private UserConnectionResponse toResponse(UserConnection connection) {
        UserConnectionResponse resp = new UserConnectionResponse();
        resp.setConnectionId(connection.getConnectionId());
        resp.setUserId(connection.getUserId());
        resp.setConnectedUserId(connection.getConnectedUserId());
        resp.setStatus(connection.getStatus().name());
        resp.setCreatedAt(connection.getCreatedAt());
        return resp;
    }
}