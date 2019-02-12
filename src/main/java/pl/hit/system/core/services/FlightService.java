package pl.hit.system.core.services;

import org.springframework.stereotype.Service;
import pl.hit.system.data.model.Flight;
import pl.hit.system.data.model.Tourist;
import pl.hit.system.data.repositories.FlightRepository;
import pl.hit.system.dto.FlightDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightDTO getFlightById(Long flightId) {

        FlightDTO flightDTO = null;
        Flight flight = flightRepository.getFlightById(flightId);

        if (flight != null) {
            flightDTO = new FlightDTO();
            flightDTO.setId(flight.getId());
            flightDTO.setDepartureTime(flight.getDepartureTime());
            flightDTO.setArrivalTime(flight.getArrivalTime());
            flightDTO.setAmountOfSeats(flight.getAmountOfSeats());
            flightDTO.setTicketPrice(flight.getTicketPrice());
            flightDTO.setTouristList(flight.getTouristList());
        }
        return flightDTO;
    }

    public List<FlightDTO> getAllFlights() {

        List<Flight> flights = flightRepository.findAll();
        List<FlightDTO> flightsDTO = flights
                .stream()
                .filter(flight -> flight != null)
                .map(flight -> {
                    FlightDTO flightDTO = new FlightDTO();
                    flightDTO.setId(flight.getId());
                    flightDTO.setDepartureTime(flight.getDepartureTime());
                    flightDTO.setArrivalTime(flight.getArrivalTime());
                    flightDTO.setAmountOfSeats(flight.getAmountOfSeats());
                    flightDTO.setTicketPrice(flight.getTicketPrice());
//                    flightDTO.setTouristList(flight.getTouristList());
                    return flightDTO;
                })
                .collect(Collectors.toList());
        return flightsDTO;
    }

    public void saveFlight(FlightDTO flightDTO) {

        Flight flight = new Flight();
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flight.setAmountOfSeats(flightDTO.getAmountOfSeats());
        flight.setTicketPrice(flightDTO.getTicketPrice());

        flightRepository.saveFlight(flight.getDepartureTime(),
                flight.getArrivalTime(), flight.getAmountOfSeats(),
                flight.getTicketPrice());

    }

    public void deleteFlight(FlightDTO flightDTO) {

        Flight flight = flightRepository.getFlightById(flightDTO.getId());

        if (flight.getTouristList() != null) {
            List<Tourist> flightsTourists = flight.getTouristList();
            for (int i = 0; i < flightsTourists.size(); i++) {
                flightRepository.deleteTouristsByTouristId(flightsTourists.get(i).getId());
            }
            flight.setTouristList(null);
        }
        flightRepository.deleteFlightById(flight.getId());
    }

    public int getAmountOfTourists(FlightDTO flightDTO) {

        Flight flight = flightRepository.getFlightById(flightDTO.getId());

        int amountOfTourists = flightRepository.getAmountOfTourists(flight.getId());

        return amountOfTourists;
    }
}
