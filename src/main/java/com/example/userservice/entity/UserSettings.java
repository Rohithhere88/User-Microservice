// src/main/java/com/example/userservice/entity/UserSettings.java
package com.example.userservice.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "user_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSettings {
    @Id
    private Long userId;

    private Boolean allowMessages = true;
    private Boolean allowProfileSuggestions = true;
}