// src/main/java/com/example/userservice/service/UserAddressService.java
package com.example.userservice.service;

import com.example.userservice.dto.UserAddressRequest;
import com.example.userservice.dto.UserAddressResponse;
import com.example.userservice.entity.UserAddress;
import com.example.userservice.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAddressService {
    @Autowired
    private UserAddressRepository userAddressRepository;

    public UserAddressResponse create(UserAddressRequest request) {
        UserAddress address = UserAddress.builder()
                .userId(request.getUserId())
                .label(request.getLabel())
                .address(request.getAddress())
                .isDefault(request.getIsDefault() != null ? request.getIsDefault() : false)
                .build();
        address = userAddressRepository.save(address);
        return toResponse(address);
    }

    public List<UserAddressResponse> getByUserId(Long userId) {
        return userAddressRepository.findByUserId(userId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public UserAddressResponse update(Long addressId, UserAddressRequest request) {
        UserAddress address = userAddressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        address.setLabel(request.getLabel());
        address.setAddress(request.getAddress());
        address.setIsDefault(request.getIsDefault());
        address = userAddressRepository.save(address);
        return toResponse(address);
    }

    public void delete(Long addressId) {
        userAddressRepository.deleteById(addressId);
    }

    private UserAddressResponse toResponse(UserAddress address) {
        UserAddressResponse resp = new UserAddressResponse();
        resp.setAddressId(address.getAddressId());
        resp.setUserId(address.getUserId());
        resp.setLabel(address.getLabel());
        resp.setAddress(address.getAddress());
        resp.setIsDefault(address.getIsDefault());
        return resp;
    }
}