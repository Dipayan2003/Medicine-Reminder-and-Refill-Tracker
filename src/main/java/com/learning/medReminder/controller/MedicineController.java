package com.learning.medReminder.controller;

import com.learning.medReminder.dto.MedicineDTO;
import com.learning.medReminder.entity.Medicine;
import com.learning.medReminder.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @PostMapping
    public MedicineDTO createMedicine(@RequestBody MedicineDTO dto) {

        Medicine created = medicineService.createMedicine(dto);

        return new MedicineDTO(
                created.getName(),
                created.getDosage(),
                created.getTimes()
        );
    }

    @GetMapping("/my")
    public List<MedicineDTO> getMyMedicines() {

        return medicineService.getMyMedicines()
                .stream()
                .map(med -> new MedicineDTO(
                        med.getName(),
                        med.getDosage(),
                        med.getTimes()
                ))
                .toList();
    }
}

