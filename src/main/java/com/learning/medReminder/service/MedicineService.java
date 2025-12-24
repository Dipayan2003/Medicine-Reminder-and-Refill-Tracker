package com.learning.medReminder.service;

import com.learning.medReminder.dto.MedicineDTO;
import com.learning.medReminder.entity.Medicine;
import com.learning.medReminder.entity.User;
import com.learning.medReminder.repository.MedicineRepository;
import com.learning.medReminder.repository.UserRepository;
import com.learning.medReminder.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final UserRepository userRepository;

    public Medicine createMedicine(MedicineDTO dto) {

        String username = SecurityUtil.getLoggedInUsername();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Logged-in user not found"));

        Medicine medicine = new Medicine(
                null,
                dto.getName(),
                dto.getDosage(),
                dto.getTimes(),
                user
        );

        return medicineRepository.save(medicine);
    }

    public List<Medicine> getMyMedicines() {

        String username = SecurityUtil.getLoggedInUsername();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Logged-in user not found"));

        return medicineRepository.findByUserId(user.getId());
    }
}

