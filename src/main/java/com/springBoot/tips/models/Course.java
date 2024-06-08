package com.springBoot.tips.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "course_sequence"
    )
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    private Long id;

    private String title;

    private String description;

}
