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
@Table(name = "resource")
public class Resource extends BaseEntity{
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
