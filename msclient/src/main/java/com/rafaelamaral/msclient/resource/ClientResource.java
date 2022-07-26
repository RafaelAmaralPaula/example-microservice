package com.rafaelamaral.msclient.resource;

import com.rafaelamaral.msclient.dto.ClientDTO;
import com.rafaelamaral.msclient.entity.Client;
import com.rafaelamaral.msclient.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientResource {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody ClientDTO dto){
        log.info("Salvando um cliente");
        var entity = dto.toModel();
        clientService.save(entity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .query("cpf={cpf}")
                .buildAndExpand(entity.getCpf())
                .toUri();

        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Client> findByCpf (@RequestParam("cpf") String cpf){
        log.info("Obtendo um cliente pelo cpf");
        var client = clientService.findByCpf(cpf);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(client.get());
    }

}
