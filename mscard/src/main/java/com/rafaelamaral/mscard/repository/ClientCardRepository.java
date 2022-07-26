package com.rafaelamaral.mscard.repository;

import com.rafaelamaral.mscard.entity.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByCpf(String cpf);
}
