package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.Flight;

import java.time.LocalDateTime;

@Transactional
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight getFlightById(Long flightId);


    @Modifying
    @Query(nativeQuery = true, value =
            "Insert into flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES(?1, ?2, ?3, ?4)")
    void saveFlight(LocalDateTime departureTime, LocalDateTime arrivalTime, Integer amountOfSeats, Double ticketPrice);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tourist_flights WHERE tourist_id = ?1")
    void deleteTouristsByTouristId(Long touristId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM flights WHERE id = ?1")
    void deleteFlightById(Long flightId);
}
