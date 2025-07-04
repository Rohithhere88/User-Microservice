// src/main/java/com/example/userservice/repository/UserAddressRepository.java
package com.example.userservice.repository;

import com.example.userservice.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    List<UserAddress> findByUserId(Long userId);
}