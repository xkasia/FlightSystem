package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hit.system.data.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
