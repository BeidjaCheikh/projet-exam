package org.sid.immatriculation.feign;

import org.sid.immatriculation.model.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "INFRACTION-SERVICE")
public interface InfractionFeignClient {

    // Get infraction
    @GetMapping("/web/infractions/{id}")
    Infraction getInfraction(@PathVariable("id") Long id);

    // Get infractions by radar id
    @GetMapping("/web/infractions/radar/{id}")
    List<Infraction> getInfractionsByRadarId(@PathVariable("id") Long id);

    // Save infraction
    @PostMapping("/web/infractions")
    Infraction saveInfraction(@RequestBody Infraction infraction);
}
