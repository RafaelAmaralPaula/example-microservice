package com.rafaelamaral.mscard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_card")
public class Card{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypeFlag flag;

    private BigDecimal income;

    @Column(name = "limit_basic")
    private BigDecimal limitBasic;

    public Card(String name, TypeFlag flag, BigDecimal income, BigDecimal limitBasic) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.limitBasic = limitBasic;
    }
}
