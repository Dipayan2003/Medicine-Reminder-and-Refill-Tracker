package com.learning.medReminder.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dosage;

    @ElementCollection
    @CollectionTable(name = "medicine_times", joinColumns = @JoinColumn(name = "medicine_id"))
    @Column(name = "time")
    private List<LocalTime> times;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
