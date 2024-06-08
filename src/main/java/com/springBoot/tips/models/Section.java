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
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "section_sequence"
    )
    @SequenceGenerator(
            name = "section_sequence",
            sequenceName = "section_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    private Long id;

    private String name;

    private int order;
}
