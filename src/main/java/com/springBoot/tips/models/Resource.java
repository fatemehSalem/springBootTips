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
@Table(name = "resource")
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
    @Column(nullable = false)
    private Long id;

    private String name;

    private int size;

    private String url;
}
