// src/main/java/com/example/userservice/controller/UserAddressController.java
package com.example.userservice.controller;

import com.example.userservice.dto.UserAddressRequest;
import com.example.userservice.dto.UserAddressResponse;
import com.example.userservice.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-addresses")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @PostMapping
    public ResponseEntity<UserAddressResponse> create(@RequestBody UserAddressRequest request) {
        return ResponseEntity.ok(userAddressService.create(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserAddressResponse>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userAddressService.getByUserId(userId));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<UserAddressResponse> update(@PathVariable Long addressId, @RequestBody UserAddressRequest request) {
        return ResponseEntity.ok(userAddressService.update(addressId, request));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable Long addressId) {
        userAddressService.delete(addressId);
        return ResponseEntity.noContent().build();
    }
}