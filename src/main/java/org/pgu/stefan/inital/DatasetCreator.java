package org.pgu.stefan.inital;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pgu.stefan.domain.JobStatus;
import org.pgu.stefan.store.entity.*;
import org.pgu.stefan.store.repository.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

@RequiredArgsConstructor
@Component
public class DatasetCreator {

    private final CarRepository carRepository;
    private final JobRepository jobRepository;
    private final ClientRepository clientRepository;
    private final MasterRepository masterRepository;
    private final ServiceRepository serviceRepository;
    private final JobStatusRepository jobStatusRepository;
    private final MasterJobRepository masterJobRepository;
    private final CarStationRepository carStationRepository;
    private final MasterServiceRepository masterServiceRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initStatuses() {

        // Создание клиентов
        ClientEntity client = clientRepository.save(
                ClientEntity.builder()
                        .firstName("Стеф")
                        .lastName("Лысак")
                        .secondName("Олеговна")
                        .phoneNumber("88005553535")
                        .build()
        );
        // Создание клиентов

        // Создание машин
        CarEntity carVesta = carRepository.save(
                CarEntity.builder()
                        .model("Lada Vesta")
                        .vinNumber("JH4DA3462JS027249")
                        .releaseDate(new GregorianCalendar(2015, 6, 10).getTime())
                        .client(client)
                        .build()
        );

        CarEntity carToyota = carRepository.save(
                CarEntity.builder()
                        .model("Toyota Rav 4")
                        .vinNumber("WH4233462JS027249")
                        .releaseDate(new GregorianCalendar(2011, 5, 14).getTime())
                        .client(client)
                        .build()
        );
        // Создание машин

        // Создание СТО
        CarStationEntity carStation = carStationRepository.save(
                CarStationEntity.builder()
                        .name("Золотые времена")
                        .address("г. Пенза, ул. Московская 65")
                        .legalAddress("г. Пенза, ул. Московская 66")
                        .build()
        );
        // Создание СТО

        // Создание мастеров
        MasterEntity master = masterRepository.save(
                MasterEntity.builder()
                        .firstName("Анатолий")
                        .lastName("Палено")
                        .secondName("Терентьевич")
                        .phoneNumber("89595675825")
                        .experience("10 лет")
                        .carStation(carStation)
                        .build()
        );
        // Создание мастеров

        // Создание услуг
        ServiceEntity tireService = serviceRepository.save(
                ServiceEntity.builder()
                        .name("Шиномонтаж")
                        .build()
        );

        ServiceEntity oilChangeService = serviceRepository.save(
                ServiceEntity.builder()
                        .name("Замена масла")
                        .build()
        );
        // Создание услуг

        // Закрепление услуг за мастерами
        masterServiceRepository.save(
                MasterServiceEntity.builder()
                        .master(master)
                        .service(tireService)
                        .priceRubles(2000D)
                        .workDurationSeconds(Duration.ofMinutes(30).toSeconds())
                        .build()
        );

        masterServiceRepository.save(
                MasterServiceEntity.builder()
                        .master(master)
                        .service(oilChangeService)
                        .priceRubles(800D)
                        .workDurationSeconds(Duration.ofMinutes(15).toSeconds())
                        .build()
        );
        // Закрепление услуг за мастерами

        ZonedDateTime date = new GregorianCalendar().toZonedDateTime();

        // Назначение работы за местром
        JobEntity vestaOilChangeJob = jobRepository.save(
                JobEntity.builder()
                        .startedAt(date)
                        .finishedAt(date.plus(Duration.ofMinutes(30)))
                        .service(oilChangeService)
                        .car(carVesta)
                        .priceRubles(1000D)
                        .build()
        );

        masterJobRepository.save(
                MasterJobEntity.builder()
                        .master(master)
                        .job(vestaOilChangeJob)
                        .build()
        );

        jobStatusRepository.save(
                JobStatusEntity.builder()
                        .jobId(vestaOilChangeJob.getId())
                        .status(JobStatus.CREATED)
                        .updatedAt(new GregorianCalendar().getTime())
                        .build()
        );
        // Назначение работы за местром

        // Назначение работы за местром
        JobEntity toyotaOilChangeJob = jobRepository.save(
                JobEntity.builder()
                        .startedAt(date)
                        .finishedAt(date.plus(Duration.ofMinutes(30)))
                        .service(oilChangeService)
                        .car(carVesta)
                        .priceRubles(1000D)
                        .build()
        );

        masterJobRepository.save(
                MasterJobEntity.builder()
                        .master(master)
                        .job(vestaOilChangeJob)
                        .build()
        );

        jobStatusRepository.save(
                JobStatusEntity.builder()
                        .jobId(vestaOilChangeJob.getId())
                        .status(JobStatus.CREATED)
                        .updatedAt(new GregorianCalendar().getTime())
                        .build()
        );
        // Назначение работы за местром
    }
}
