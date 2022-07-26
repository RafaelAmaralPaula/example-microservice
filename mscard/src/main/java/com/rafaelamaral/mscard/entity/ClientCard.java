package com.rafaelamaral.mscard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "client_card")
@Data
@NoArgsConstructor
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;

    @Column(name = "limit_aproved")
    private BigDecimal limitAproved;



}
