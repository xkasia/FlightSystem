package pl.hit.system.core.services;


import org.springframework.stereotype.Service;
import pl.hit.system.data.repositories.FlightRepository;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
}
