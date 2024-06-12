package com.springBoot.tips.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "customers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_seq"
    )
    private Long id;

    @Column(
            nullable = false,
            unique = true
    )
    @NotEmpty(message = "Email can not be Empty")
    @Email(message = "Email is invalid")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Name can not be Empty")
    private String name;

}
