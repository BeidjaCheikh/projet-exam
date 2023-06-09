package org.sid.immatriculation.repositories;

import org.sid.immatriculation.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface RadarRepository extends JpaRepository<Radar, Long> {

}
