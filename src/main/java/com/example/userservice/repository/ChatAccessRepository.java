// src/main/java/com/example/userservice/repository/ChatAccessRepository.java
package com.example.userservice.repository;

import com.example.userservice.entity.ChatAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatAccessRepository extends JpaRepository<ChatAccess, Long> {
}