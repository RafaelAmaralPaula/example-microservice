package com.rafaelamaral.mscard.resource;

import com.rafaelamaral.mscard.dto.CardDTO;
import com.rafaelamaral.mscard.dto.ClientCardDTO;
import com.rafaelamaral.mscard.entity.Card;
import com.rafaelamaral.mscard.entity.ClientCard;
import com.rafaelamaral.mscard.service.CardService;
import com.rafaelamaral.mscard.service.ClientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;

    private final ClientCardService clientCardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody CardDTO dto){
        Card entity = dto.toModel();
        cardService.save(entity);
        URI uri = ServletUriComponentsBuilder
                        .fromCurrentRequestUri()
                        .query("id={id}")
                        .buildAndExpand(entity.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> findByIncome(@RequestParam("income")Long income){
        List<Card> cards = cardService.findByIncomeLessThanEquals(income);
        return ResponseEntity.ok().body(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardDTO>> listCardByCpfClient(@RequestParam("cpf") String cpf){
        List<ClientCard> clientCards = clientCardService.listCardByCpfClient(cpf);
        List<ClientCardDTO> clientcardDTOS = clientCards.stream()
                    .map(ClientCardDTO::toModel).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientcardDTOS);

    }

}
