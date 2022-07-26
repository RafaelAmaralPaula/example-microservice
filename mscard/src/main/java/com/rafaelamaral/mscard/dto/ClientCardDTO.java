package com.rafaelamaral.mscard.dto;

import com.rafaelamaral.mscard.entity.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCardDTO {

    private String name;

    private String flag;

    private BigDecimal limitRealeased;

    public static ClientCardDTO toModel(ClientCard entity){
        return new ClientCardDTO(
                entity.getCard().getName(),
                entity.getCard().getFlag().toString(),
                entity.getLimitAproved()
        );

    }

}
