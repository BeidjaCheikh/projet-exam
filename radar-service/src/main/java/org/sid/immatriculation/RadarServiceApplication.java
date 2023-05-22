package org.sid.immatriculation;

import org.sid.immatriculation.entities.Radar;
import org.sid.immatriculation.feign.InfractionFeignClient;
import org.sid.immatriculation.feign.RegistrationFeignClient;
import org.sid.immatriculation.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class RadarServiceApplication implements CommandLineRunner {

	private final RadarRepository radarRepository;
	private final RegistrationFeignClient registrationFeignClient;
	private final InfractionFeignClient infractionFeignClient;

	public RadarServiceApplication(RadarRepository radarRepository, RegistrationFeignClient registrationFeignClient, InfractionFeignClient infractionFeignClient) {
		this.radarRepository = radarRepository;
		this.registrationFeignClient = registrationFeignClient;
		this.infractionFeignClient = infractionFeignClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(RadarServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Random random = new Random();
		// Add some radars
		for(int i = 0; i < 10; i++) {
			double longitude = random.nextDouble() * 360 - 180;  // Valeur aléatoire entre -180 et 180
			double latitude = random.nextDouble() * 180 - 90;  // Valeur aléatoire entre -90 et 90

			Radar radar = new Radar();
			radar.setMaxSpeed(100.0 + i);
			radar.setLatitude(longitude);
			radar.setLongitude(latitude);
			radarRepository.save(radar);
			System.out.println(radar);
		}
		// Add new infraction by radar 3 and vehicle 2

	}
}
