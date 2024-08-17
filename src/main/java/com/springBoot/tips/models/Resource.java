package com.springBoot.tips.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@SuperBuilder
@Table(name = "resource")
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "resource_sequence"
    )
    @SequenceGenerator(
            name = "resource_sequence",
            sequenceName = "resource_sequence",
            allocationSize = 1
    )
    @Column(nullable = false, name = "resource_id")
    private Long id;

    private String name;

    private int size;

    private String url;
}
