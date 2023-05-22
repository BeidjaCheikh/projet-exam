package org.sid.immatriculation.feign;

import org.sid.immatriculation.model.Owner;
import org.sid.immatriculation.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IMMATRICULATION-SERVICE")
public interface RegistrationFeignClient {
    // Check if owner exists
    @GetMapping("/web/owners/exist/{id}")
    boolean isOwnerExistsById(@PathVariable("id") Long id);

    // Get owner
    @GetMapping("/web/owners/{id}")
    Owner getOwner(@PathVariable("id") Long id);

    // Check if vehicle exists
    @GetMapping("/web/vehicles/exist/{id}")
    boolean isVehicleExistsById(@PathVariable("id") Long id);

    // Get vehicle
    @GetMapping("/web/vehicles/{id}")
    Vehicle getVehicle(@PathVariable("id") Long id);
}
