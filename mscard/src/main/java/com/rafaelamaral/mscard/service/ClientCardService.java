package com.rafaelamaral.mscard.service;

import com.rafaelamaral.mscard.entity.ClientCard;
import com.rafaelamaral.mscard.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    @Transactional(readOnly = true)
    public List<ClientCard> listCardByCpfClient(String cpf){
        return clientCardRepository.findByCpf(cpf);
    }

}
