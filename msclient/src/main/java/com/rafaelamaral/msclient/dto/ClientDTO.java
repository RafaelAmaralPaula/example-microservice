package com.rafaelamaral.msclient.dto;

import com.rafaelamaral.msclient.entity.Client;
import lombok.Data;

@Data
public class ClientDTO {

    private String name;

    private String cpf;

    private Integer age;

    public Client toModel(){
        return new Client(name , cpf , age);
    }
}
