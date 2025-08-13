package com.learning.medReminder.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;  // Add this
    private String name;
    private String email;
    private List<MedicineDTO> medicines;  // And this
}