package org.sid.immatriculation.web;

import org.sid.immatriculation.entities.Radar;
import org.sid.immatriculation.feign.InfractionFeignClient;
import org.sid.immatriculation.feign.RegistrationFeignClient;
import org.sid.immatriculation.model.Infraction;
import org.sid.immatriculation.model.Vehicle;
import org.sid.immatriculation.repositories.RadarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/web")
public class RadarRestController {
    private final RadarRepository radarRepository;
    private final RegistrationFeignClient registrationFeignClient;
    private final InfractionFeignClient infractionFeignClient;

    public RadarRestController(RadarRepository radarRepository, RegistrationFeignClient registrationFeignClient, InfractionFeignClient infractionFeignClient) {
        this.radarRepository = radarRepository;
        this.registrationFeignClient = registrationFeignClient;
        this.infractionFeignClient = infractionFeignClient;
    }

    // Simple CRUD operations
    // - Read all
    @GetMapping("/radars")
    public List<Radar> getRadars(){
        List<Radar> radars = radarRepository.findAll();
        for(Radar radar : radars){

            List<Infraction> infractions = infractionFeignClient.getInfractionsByRadarId(radar.getId());
            for(Infraction infraction : infractions){
                Vehicle vehicle = registrationFeignClient.getVehicle(infraction.getVehicleId());
                infraction.setVehicle(vehicle);
            }
            radar.setInfractions(infractions);
        }
        return radars;
    }

    // - Read by id
    @GetMapping("/radars/{id}")
    public Radar getRadar(@PathVariable("id") Long id){
        return radarRepository.findById(id).get();
    }

    // - Save radar
    @PostMapping("/radars")
    public Radar saveRadar(@RequestBody Radar radar){
        return radarRepository.save(radar);
    }

    // - Update
    @PutMapping("/radars/{id}")
    public Radar updateRadar(@PathVariable("id") Long id,@RequestBody Radar radar){
        if(radarRepository.existsById(id)){
            Radar savedRadar = radarRepository.findById(id).get();

            if(radar.getMaxSpeed() != null) savedRadar.setMaxSpeed(radar.getMaxSpeed());
            if(radar.getLatitude() != null) savedRadar.setLatitude(radar.getLatitude());
            if(radar.getLongitude() != null) savedRadar.setLongitude(radar.getLongitude());

            return radarRepository.save(savedRadar);
        }
        return null;
    }

    // - Delete
    @DeleteMapping("/radars/{id}")
    public boolean deleteRadar(@PathVariable("id") Long id){
        if(radarRepository.existsById(id)){
            radarRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Add speed infractions
    @PostMapping("/radars/{id}/vehicles/{vehicleId}")
    public Infraction addSpeedInfraction(@PathVariable("id") Long id, @PathVariable("vehicleId") Long vehicleId, @RequestParam("speed") Double speed){
        if(radarRepository.existsById(id) && registrationFeignClient.isVehicleExistsById(vehicleId)){
            Radar radar = radarRepository.findById(id).get();
            Vehicle vehicle = registrationFeignClient.getVehicle(vehicleId);
            if (speed > radar.getMaxSpeed()){
                Infraction infraction = Infraction.builder()
                        .id(null)
                        .date(new Date().toString())
                        .vehicleSpeed(speed)
                        .radarMaxSpeed(radar.getMaxSpeed())
                        .fineAmount((speed - radar.getMaxSpeed()) * 100)
                        .radarId(radar.getId())
                        .vehicleId(vehicle.getId())
                        .vehicle(vehicle)
                        .radar(radar)
                        .build();
                infraction = infractionFeignClient.saveInfraction(infraction);
                infraction.setVehicle(vehicle);
                infraction.setRadar(radar);
                return infraction;
            }
        }
        return null;
    }
}
