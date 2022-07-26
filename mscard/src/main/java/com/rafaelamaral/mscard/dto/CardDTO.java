package com.rafaelamaral.mscard.dto;

import com.rafaelamaral.mscard.entity.Card;
import com.rafaelamaral.mscard.entity.TypeFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDTO {

    private Long id;

    private String name;

    private TypeFlag flag;

    private BigDecimal income;

    private BigDecimal limitBasic;

    public Card toModel(){
        return new Card(name , flag , income , limitBasic);
    }

}
