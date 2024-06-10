package com.springBoot.tips.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "course")
public class Course extends BaseEntity{
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
