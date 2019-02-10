package pl.hit.system.core.services;

import org.springframework.stereotype.Service;
import pl.hit.system.data.model.Flight;
import pl.hit.system.data.model.Tourist;
import pl.hit.system.data.repositories.FlightRepository;
import pl.hit.system.data.repositories.TouristRepository;
import pl.hit.system.dto.FlightDTO;
import pl.hit.system.dto.TouristDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristService {

    private TouristRepository touristRepository;
    private FlightRepository flightRepository;

    public TouristService(TouristRepository touristRepository, FlightRepository flightRepository) {
        this.touristRepository = touristRepository;
        this.flightRepository = flightRepository;
    }

    public List<TouristDTO> getAllTourists() {
        return touristRepository.findAll().stream()
                .filter(tourist -> tourist != null)
                .map(tourist -> {
                    TouristDTO touristDTO = new TouristDTO();
                    touristDTO.setId(tourist.getId());
                    touristDTO.setFirstName(tourist.getFirstName());
                    touristDTO.setLastName(tourist.getLastName());
                    touristDTO.setCountry(tourist.getCountry());
                    touristDTO.setBirthDate(tourist.getBirthDate());
                    return touristDTO;
                }).collect(Collectors.toList());
    }

    public TouristDTO getTouristByID(Long touristId) {

        TouristDTO touristDTO = null;
        Tourist tourist = touristRepository.getTouristById(touristId);

        if (tourist != null) {
            touristDTO = new TouristDTO();
            touristDTO.setId(tourist.getId());
            touristDTO.setFirstName(tourist.getFirstName());
            touristDTO.setLastName(tourist.getLastName());
            touristDTO.setCountry(tourist.getCountry());
            touristDTO.setNote(tourist.getNote());
            touristDTO.setFlightsList(tourist.getFlightsList());
            touristDTO.setBirthDate(tourist.getBirthDate());
        }
        return touristDTO;
    }

    public void deleteTourist(TouristDTO touristDTO) {

        Tourist tourist = touristRepository.getTouristById(touristDTO.getId());

        if (tourist.getFlightsList() != null) {
            List<Flight> touristsFlights = tourist.getFlightsList();
            for (int i = 0; i < touristsFlights.size(); i++) {
                touristRepository.deleteFlightsByFlightId(touristsFlights.get(i).getId());
            }
            tourist.setFlightsList(null);
        }
        touristRepository.deleteTouristById(tourist.getId());
    }

    public void deleteFlight(TouristDTO touristDTO, FlightDTO flightDTO) {
        Tourist tourist = touristRepository.getTouristById(touristDTO.getId());
        Flight flight = flightRepository.getFlightById(flightDTO.getId());

        touristRepository.deleteFlight(flight.getId(), tourist.getId());
    }

    public void addTouristFlight(Long flightId, Long touristId) {
        Tourist tourist = touristRepository.getTouristById(touristId);
        Flight flight = flightRepository.getFlightById(flightId);

        touristRepository.saveTouristFlight(flight.getId(), tourist.getId());
    }

    public boolean checkIfTouristBookedFlight(Long flightId, Long touristId) {
        Tourist tourist = touristRepository.getTouristById(touristId);
        Flight flight = flightRepository.getFlightById(flightId);

        int amountOfBookedPlaces = touristRepository.getAmountOfPlecesBookedbyTouristInSpecifiedFlight(flight.getId(), tourist.getId());

        if (amountOfBookedPlaces == 1) {
            return true;
        }
        return false;
    }

    public void saveTourist(TouristDTO touristDTO) {

        Tourist tourist = new Tourist();
        tourist.setId(touristDTO.getId());
        tourist.setFirstName(touristDTO.getFirstName());
        tourist.setLastName(touristDTO.getLastName());
        tourist.setCountry(touristDTO.getCountry());
        tourist.setNote(touristDTO.getNote());
        tourist.setBirthDate(touristDTO.getBirthDate());

        touristRepository.saveTourist(tourist.getFirstName(), tourist.getLastName(), tourist.getCountry(),
                tourist.getNote(), tourist.getBirthDate());
    }
}
