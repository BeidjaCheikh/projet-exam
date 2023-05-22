package org.sid.immatriculation;

import org.sid.immatriculation.dto.OwnerRequest;
import org.sid.immatriculation.dto.VehicleRequest;
import org.sid.immatriculation.web.rest.RestOwnerController;
import org.sid.immatriculation.web.rest.RestVehicleController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class RegistrationServiceApplication implements CommandLineRunner {

    private final RestOwnerController restOwnerController;
    private final RestVehicleController restVehicleController;

    public RegistrationServiceApplication(RestOwnerController restOwnerController, RestVehicleController restVehicleController) {
        this.restOwnerController = restOwnerController;
        this.restVehicleController = restVehicleController;
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // Create owners
        Stream.of("Cheikh", "Ahmed", "Ali", "Zahra", "sanae","Sidi").forEach(name -> {
            OwnerRequest ownerRequest = OwnerRequest.builder()
                    .name(name)
                    .birthDate(new Date().toString())
                    .email(name + "@gmail.com")
                    .build();
            restOwnerController.saveOwner(ownerRequest);
        });

        // Create vehicles and link them with owners
        restOwnerController.getOwners().forEach(owner -> {
            Stream.of("Audi", "Mercedes", "BMW","Toyota").forEach(brand -> {
                VehicleRequest vehicleRequest = VehicleRequest.builder()
                        .regNumber("ABC-" + Math.random() * 10000)
                        .brand(brand)
                        .fiscalPower((float)(Math.random() * 10))
                        .model("model " + Math.random() * 100)
                        .build();

                Long vehicleId = restVehicleController.saveVehicle(vehicleRequest).getId();
                Long ownerId = owner.getId();

                restVehicleController.addVehicleToOwner(vehicleId, ownerId);
            });
        });
    }
}
