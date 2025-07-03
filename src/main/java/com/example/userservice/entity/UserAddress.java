// src/main/java/com/example/userservice/entity/UserAddress.java
package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "user_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private Long userId;

    private String label;

    @Column(nullable = false)
    private String address;

    private Boolean isDefault = false;
}