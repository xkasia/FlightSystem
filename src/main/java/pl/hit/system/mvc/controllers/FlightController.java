package pl.hit.system.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hit.system.core.forms.FlightAddForm;
import pl.hit.system.core.forms.TouristAddForm;
import pl.hit.system.core.services.FlightService;
import pl.hit.system.core.services.TouristService;
import pl.hit.system.dto.FlightDTO;
import pl.hit.system.dto.TouristDTO;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/flight")
public class FlightController {

    TouristService touristService;
    FlightService flightService;
    private Long touristId;
    private Long flightId;

    public FlightController(TouristService touristService, FlightService flightService) {
        this.touristService = touristService;
        this.flightService = flightService;
    }

    @GetMapping("/show")
    public String showTourists(Model model) {
        List<FlightDTO> flights = flightService.getAllFlights();

        model.addAttribute("flights", flights);
        return "/flight/show";
    }

    @GetMapping("/add")
    public String showAddUserPage(Model model) {
        model.addAttribute("flight", new FlightAddForm());
        return "/flight/add";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("tourist") FlightAddForm flightAddForm,
                          BindingResult bindingResult, String departureTime, String arrivalTime, Model model) {
        if (bindingResult.hasErrors()) {
            return "/tourist/add";
        }
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setDepartureTime(LocalDateTime.parse(departureTime));
        flightDTO.setArrivalTime(LocalDateTime.parse(arrivalTime));
        flightDTO.setAmountOfSeats(flightAddForm.getAmountOfSeats());
        flightDTO.setTicketPrice(flightAddForm.getTicketPrice());
        flightService.saveFlight(flightDTO);

        return "redirect:/flight/show";
    }

    @GetMapping("/manage/{flightId:[0-9]+}")
    public String manageTourist(@PathVariable Long flightId, Model model) {
        this.flightId = flightId;
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        boolean hasFreePlace = false;

        if (flightDTO.getTouristList().size() < flightDTO.getAmountOfSeats()) {
            hasFreePlace = true;
        }

        model.addAttribute("hasFreePlace", hasFreePlace);
        model.addAttribute("flight", flightDTO);
        return "flight/manage";
    }

    @GetMapping("/delete")
    public String showDeleteFlightPage() {
        return "flight/delete";
    }

    @PostMapping("/delete")
    public String deleteUser(String delete) {

        if (delete.equals("yes")) {
            FlightDTO flightDTO = flightService.getFlightById(flightId);
            flightService.deleteFlight(flightDTO);
            return "redirect:/flight/show";
        }
        return "redirect:/flight/manage/" + flightId;
    }

    @GetMapping("/tourist/delete/{touristId:[0-9]+}")
    public String showDeleteFlightPage(@PathVariable Long touristId) {
        this.touristId = touristId;
        return "flight/tourist/delete";
    }

    @PostMapping("/tourist/delete")
    public String deleteFlight(String delete) {
        if (delete.equals("yes")) {
            TouristDTO touristDTO = touristService.getTouristByID(touristId);
            FlightDTO flightDTO = flightService.getFlightById(flightId);
            touristService.deleteFlight(touristDTO, flightDTO);
        }
        return "redirect:/flight/manage/" + touristId;
    }

    @GetMapping("/tourist/all")
    public String showAllAvailableTouristsPage(Model model) {

        FlightDTO flightDTO = flightService.getFlightById(flightId);

        List<TouristDTO> touristList = touristService.getAllTourists();
        Map<Long, Boolean> isAlreadyBookedMap = new HashMap<>();

        for (int i = 0; i < touristList.size(); i++) {

            // check if already booked
            boolean isAlreadyBooked = touristService.checkIfTouristBookedFlight(flightDTO.getId(), touristList.get(i).getId());
            if (isAlreadyBooked) {
                isAlreadyBookedMap.put(touristList.get(i).getId(), true);
            } else {
                isAlreadyBookedMap.put(touristList.get(i).getId(), false);
            }
        }

        model.addAttribute("isAlreadyBooked", isAlreadyBookedMap);
        model.addAttribute("tourists", touristList);
        return "/flight/tourist/all";
    }


    @GetMapping("/tourist/add/{touristId:[0-9]+}")
    public String showAddTouristPage(@PathVariable Long touristId) {
        this.touristId = touristId;

        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        touristService.addTouristFlight(flightDTO.getId(), touristDTO.getId());

        return "redirect:/flight/manage/" + flightId;
    }
}


