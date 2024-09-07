package com.springBoot.tips.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "strategy")
public class Strategy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /*    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "strategy_table")
    @TableGenerator(name = "resource_table",
            table = "id_generator",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "resource_id",
            allocationSize = 1)
    private Long id;*/
}

