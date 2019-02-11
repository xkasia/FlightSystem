package pl.hit.system.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hit.system.core.forms.TouristAddForm;
import pl.hit.system.core.services.FlightService;
import pl.hit.system.core.services.TouristService;
import pl.hit.system.dto.FlightDTO;
import pl.hit.system.dto.TouristDTO;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tourist")
public class TouristController {

    TouristService touristService;
    FlightService flightService;
    private Long touristId;
    private Long flightId;

    public TouristController(TouristService touristService, FlightService flightService) {
        this.touristService = touristService;
        this.flightService = flightService;
    }

    @GetMapping("/show")
    public String showTourists(Model model) {
        List<TouristDTO> tourists = touristService.getAllTourists();
        model.addAttribute("tourists", tourists);
        return "/tourist/show";
    }

    @GetMapping("/add")
    public String showAddUserPage(Model model) {
        model.addAttribute("tourist", new TouristAddForm());
        return "/tourist/add";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("tourist") TouristAddForm touristAddForm,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/tourist/add";
        }
        TouristDTO tourist = new TouristDTO(touristAddForm.getFirstName(), touristAddForm.getLastName(), touristAddForm.getCountry(),
                touristAddForm.getNote(), LocalDate.parse(touristAddForm.getBirthDate()));
        touristService.saveTourist(tourist);

        List<TouristDTO> tourists = touristService.getAllTourists();
        model.addAttribute("tourists", tourists);
        model.addAttribute("addTouristSuccessMsg", "Tourist was added successfully.");
        return "/tourist/show";
    }

    @GetMapping("/manage/{touristId:[0-9]+}")
    public String manageTourist(@PathVariable Long touristId, Model model) {
        this.touristId = touristId;
        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        model.addAttribute("tourist", touristDTO);
        return "tourist/manage";
    }

    @GetMapping("/delete")
    public String showDeleteUserPage() {
        return "tourist/delete";
    }

    @PostMapping("/delete")
    public String deleteUser(String delete, Model model) {

        if (delete.equals("yes")) {
            TouristDTO touristDTO = touristService.getTouristByID(touristId);
            touristService.deleteTourist(touristDTO);

            List<TouristDTO> tourists = touristService.getAllTourists();
            model.addAttribute("tourists", tourists);
            model.addAttribute("deleteTouristSuccessMsg", "Tourist was deleted successfully.");
            return "tourist/show";
        }
        return "redirect:/tourist/manage/" + touristId;
    }

    @GetMapping("/flight/delete/{flightId:[0-9]+}")
    public String showDeleteFlightPage(@PathVariable Long flightId) {
        this.flightId = flightId;
        return "tourist/flight/delete";
    }

    @PostMapping("/flight/delete")
    public String deleteFlight(String delete, Model model) {
        if (delete.equals("yes")) {
            TouristDTO touristDTO = touristService.getTouristByID(touristId);
            FlightDTO flightDTO = flightService.getFlightById(flightId);
            touristService.deleteFlight(touristDTO, flightDTO);
            model.addAttribute("tourist", touristDTO);
            model.addAttribute("deleteFlightFromTouristSuccessMsg", "Flight was deleted successfully.");
            return "tourist/manage";
        }
        return "redirect:/tourist/manage/" + touristId;
    }

    @GetMapping("/flight/all")
    public String showAllAvailableFlightsPage(Model model) {
        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        List<FlightDTO> flightsList = flightService.getAllFlights();
        Map<Long, Boolean> hasFreePlaceMap = new HashMap<>();
        Map<Long, Boolean> isalreadyBookedMap = new HashMap<>();

        for (int i = 0; i < flightsList.size(); i++) {
            // check if has free places
            if (flightsList.get(i).getTouristList().size() < flightsList.get(i).getAmountOfSeats()) {
                hasFreePlaceMap.put(flightsList.get(i).getId(), true);
            } else {
                hasFreePlaceMap.put(flightsList.get(i).getId(), false);
            }

            // check if already booked
            boolean isAlreadyBooked = touristService.checkIfTouristBookedFlight(flightsList.get(i).getId(), touristDTO.getId());
            if (isAlreadyBooked) {
                isalreadyBookedMap.put(flightsList.get(i).getId(), true);
            } else {
                isalreadyBookedMap.put(flightsList.get(i).getId(), false);
            }
        }
        model.addAttribute("isAlreadyBooked", isalreadyBookedMap);
        model.addAttribute("hasFreePlace", hasFreePlaceMap);
        model.addAttribute("flights", flightsList);
        return "/tourist/flight/all";
    }

    @GetMapping("/flight/add/{flightId:[0-9]+}")
    public String showAddFlightPage(@PathVariable Long flightId, Model model) {
        this.flightId = flightId;
        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        touristService.addTouristFlight(flightDTO.getId(), touristDTO.getId());

        model.addAttribute("tourist", touristDTO);
        model.addAttribute("addFlightToTouristSuccessMsg", "Flight was added successfully.");

        return "tourist/manage";
    }
}
