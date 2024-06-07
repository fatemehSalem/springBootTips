package com.springBoot.tips.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

}
