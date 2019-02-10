package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.Flight;

@Transactional
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    Flight getFlightById(Long flightId);

    @Query(nativeQuery = true, value =
            "SELECT count(Tourist_ID) from tourist_flights where flight_id = ?1")
    int getAmountOfTourists(Long flightId);
}
