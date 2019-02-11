package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.Tourist;

import java.time.LocalDate;

@Transactional
@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {

    Tourist getTouristById(Long touristId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tourists WHERE id = ?1")
    void deleteTouristById(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tourist_flights WHERE flight_id = ?1")
    void deleteFlightsByFlightId(Long flightId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tourist_flights WHERE flight_id = ?1 and tourist_id = ?2")
    void deleteFlight(Long flightId, Long touristId);

    @Modifying
    @Query(nativeQuery = true, value =
            "Insert into tourist_flights(Flight_ID, Tourist_ID)" +
                    "values(?1, ?2)")
    void saveTouristFlight(Long flightId, Long touristId);

    @Query(nativeQuery = true, value =
            "SELECT count(*) from tourist_flights where flight_id = ?1 and Tourist_ID = ?2")
    int getAmountOfPlecesBookedbyTouristInSpecifiedFlight(Long flightId, Long touristId);

    @Modifying
    @Query(nativeQuery = true, value =
            "Insert into tourists(first_name, last_name, country, note, birth_date) VALUES(?1, ?2, ?3, ?4, ?5 )")
    void saveTourist(String firstName, String lastName, String country, String note, LocalDate birthDate);
}

