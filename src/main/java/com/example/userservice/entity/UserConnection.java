// src/main/java/com/example/userservice/entity/UserConnection.java
package com.example.userservice.entity;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_connections")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long connectionId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long connectedUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @Column(nullable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public enum Status {
        PENDING, ACCEPTED, BLOCKED
    }
}