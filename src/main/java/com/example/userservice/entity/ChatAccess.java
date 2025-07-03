// src/main/java/com/example/userservice/entity/ChatAccess.java
package com.example.userservice.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_access")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatAccess {
    @Id
    private Long userId;

    private Boolean canChat = false;
}