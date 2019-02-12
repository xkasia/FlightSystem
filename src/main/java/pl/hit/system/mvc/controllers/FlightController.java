package pl.hit.system.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hit.system.core.forms.FlightAddForm;
import pl.hit.system.core.services.FlightService;
import pl.hit.system.core.services.TouristService;
import pl.hit.system.dto.FlightDTO;
import pl.hit.system.dto.TouristDTO;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private TouristService touristService;
    private FlightService flightService;
    private Long touristId;
    private Long flightId;

    public FlightController(TouristService touristService,
                            FlightService flightService) {
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
    public String addFlight(@Valid @ModelAttribute("flight") FlightAddForm flightAddForm,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "flight/add";
        }

        if (LocalDateTime.parse(flightAddForm.getDepartureTime()).compareTo(LocalDateTime.parse(flightAddForm.getArrivalTime())) > 0) {
            model.addAttribute("wrongDataMsg",
                    "Arrival time can not be before departure time. Please provide proper data.");
            return "flight/add";
        }

        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setDepartureTime(LocalDateTime.parse(flightAddForm.getDepartureTime()));
        flightDTO.setArrivalTime(LocalDateTime.parse(flightAddForm.getArrivalTime()));
        flightDTO.setAmountOfSeats(flightAddForm.getAmountOfSeats());
        flightDTO.setTicketPrice(flightAddForm.getTicketPrice().doubleValue());
        flightService.saveFlight(flightDTO);

        List<FlightDTO> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        model.addAttribute("addFlightSuccessMsg",
                "Flight was added successfully.");

        return "flight/show";
    }

    @GetMapping("/manage/{flightId:[0-9]+}")
    public String manageFlight(@PathVariable Long flightId, Model model) {
        this.flightId = flightId;
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        model.addAttribute("hasFreePlace", hasFreePlace(flightDTO));
        model.addAttribute("flight", flightDTO);
        return "flight/manage";
    }

    private boolean hasFreePlace(FlightDTO flightDTO) {
        int amountOfTourists = flightService.getAmountOfTourists(flightDTO);
        return (amountOfTourists < flightDTO.getAmountOfSeats());
    }

    @GetMapping("/delete")
    public String showDeleteFlightPage() {
        return "flight/delete";
    }

    @PostMapping("/delete")
    public String deleteFlight(String delete, Model model) {

        if (delete.equals("yes")) {
            FlightDTO flightDTO = flightService.getFlightById(flightId);
            flightService.deleteFlight(flightDTO);

            List<FlightDTO> flights = flightService.getAllFlights();
            model.addAttribute("flights", flights);
            model.addAttribute("deleteFlightSuccessMsg",
                    "Flight was deleted successfully.");
            return "flight/show";
        }
        return "redirect:/flight/manage/" + flightId;
    }

    @GetMapping("/tourist/delete/{touristId:[0-9]+}")
    public String showDeleteTouristFromFlightPage(@PathVariable Long touristId) {
        this.touristId = touristId;
        return "flight/tourist/delete";
    }

    @PostMapping("/tourist/delete")
    public String deleteTouristFromFlight(String delete, Model model) {
        if (delete.equals("yes")) {
            TouristDTO touristDTO = touristService.getTouristByID(touristId);
            FlightDTO flightDTO = flightService.getFlightById(flightId);
            touristService.deleteFlight(touristDTO, flightDTO);

            model.addAttribute("hasFreePlace", hasFreePlace(flightDTO));
            model.addAttribute("flight", flightDTO);
            model.addAttribute("deleteTouristFromFlightSuccessMsg",
                    "Flight was deleted successfully.");
            return "flight/manage";
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
            boolean isAlreadyBooked = touristService.checkIfTouristBookedFlight(flightDTO.getId(),
                    touristList.get(i).getId());
            isAlreadyBookedMap.put(touristList.get(i).getId(), isAlreadyBooked);
        }

        model.addAttribute("flight", flightDTO);
        model.addAttribute("isAlreadyBooked", isAlreadyBookedMap);
        model.addAttribute("tourists", touristList);
        return "/flight/tourist/all";
    }


    @GetMapping("/tourist/add/{touristId:[0-9]+}")
    public String showAddTouristPage(@PathVariable Long touristId, Model model) {
        this.touristId = touristId;

        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        if (touristService.checkIfTouristBookedFlight(flightDTO.getId(),
                touristDTO.getId())) {
            return "redirect:/flight/tourist/all";
        }

        touristService.addTouristFlight(flightDTO.getId(), touristDTO.getId());

        model.addAttribute("hasFreePlace", hasFreePlace(flightDTO));
        model.addAttribute("flight", flightDTO);
        model.addAttribute("addTouristToFlightSuccessMsg",
                "Tourist was added successfully.");

        return "flight/manage";
    }
}


