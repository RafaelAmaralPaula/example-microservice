package com.rafaelamaral.msclient.service;

import com.rafaelamaral.msclient.dto.ClientDTO;
import com.rafaelamaral.msclient.entity.Client;
import com.rafaelamaral.msclient.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Optional<Client> findByCpf(String cpf){
        return clientRepository.findByCpf(cpf);
    }

}
