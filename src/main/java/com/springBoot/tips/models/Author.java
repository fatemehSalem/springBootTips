package com.springBoot.tips.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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
    @Column(nullable = false)
    private Long id;

    @Column(
            nullable = false,
            length = 45
    )
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Email(message = "Email in invalid")
    private String email;

}
