package org.pgu.stefan.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgu.stefan.store.entity.CarEntity;
import org.pgu.stefan.store.entity.ClientEntity;
import org.pgu.stefan.store.repository.CarRepository;
import org.pgu.stefan.store.repository.ClientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CarController {

    public static final String ADD_CAR = "/api/cars/add";

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    @PostMapping(ADD_CAR)
    public void addCar(
            @RequestParam Long clientId,
            @RequestParam String vinNumber,
            @RequestParam String model) {

        ClientEntity client = clientRepository
                .findById(clientId)
                .orElseThrow();

        carRepository.save(
                CarEntity.builder()
                        .client(client)
                        .model(model)
                        .vinNumber(vinNumber)
                        .build()
        );
    }
}
