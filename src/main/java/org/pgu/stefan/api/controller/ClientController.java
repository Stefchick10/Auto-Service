package org.pgu.stefan.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgu.stefan.store.entity.ClientEntity;
import org.pgu.stefan.store.repository.ClientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ClientController {

    public static final String ADD_CLIENT = "/api/clients/add";
    public static final String GET_CLIENTS = "/api/clients/get";

    private final ClientRepository clientRepository;

    @PostMapping(ADD_CLIENT)
    public void addClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam(required = false) String secondName,
            @RequestParam String phoneNumber) {

        clientRepository.save(
                ClientEntity.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .secondName(secondName)
                        .phoneNumber(phoneNumber)
                        .build()
        );
    }

    @PostMapping(GET_CLIENTS)
    public List<ClientEntity> getClients() {

        List<ClientEntity> clients = clientRepository.findAll();

        return clients;
    }
}
