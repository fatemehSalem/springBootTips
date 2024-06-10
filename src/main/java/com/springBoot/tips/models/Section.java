package com.springBoot.tips.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "section")
public class Section extends BaseEntity {
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
