// src/main/java/com/example/userservice/repository/UserSettingsRepository.java
package com.example.userservice.repository;

import com.example.userservice.entity.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {
}