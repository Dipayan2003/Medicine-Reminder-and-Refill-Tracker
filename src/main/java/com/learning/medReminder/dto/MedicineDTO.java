package com.learning.medReminder.dto;

import lombok.*;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDTO {
    private String name;
    private String dosage;
    private List<LocalTime> times;
    private Long userId;
}
