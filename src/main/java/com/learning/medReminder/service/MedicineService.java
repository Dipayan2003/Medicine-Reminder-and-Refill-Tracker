package com.learning.medReminder.service;

import com.learning.medReminder.dto.MedicineDTO;
import com.learning.medReminder.entity.Medicine;
import com.learning.medReminder.entity.User;
import com.learning.medReminder.repository.MedicineRepository;
import com.learning.medReminder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final UserRepository userRepository;

    public Medicine createMedicine(MedicineDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

        Medicine medicine = new Medicine(
                null,
                dto.getName(),
                dto.getDosage(),
                dto.getTimes(),  // changed from dto.getFrequency()
                user
        );

        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicinesForUser(Long userId) {
        return medicineRepository.findByUserId(userId);
    }
}
