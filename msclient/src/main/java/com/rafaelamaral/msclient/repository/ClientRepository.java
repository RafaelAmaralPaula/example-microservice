package com.rafaelamaral.msclient.repository;

import com.rafaelamaral.msclient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client , Long> {

    Optional<Client> findByCpf(String cpf);
}
