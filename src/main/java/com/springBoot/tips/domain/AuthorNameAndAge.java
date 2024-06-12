package com.springBoot.tips.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorNameAndAge {

    private String firstName;
    private Integer age;
}
