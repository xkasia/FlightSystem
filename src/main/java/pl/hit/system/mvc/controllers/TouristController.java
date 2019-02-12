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

    public TouristController(TouristService touristService,
                             FlightService flightService) {
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
    public String addTourist(@Valid @ModelAttribute("tourist") TouristAddForm touristAddForm,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/tourist/add";
        }

        TouristDTO tourist = new TouristDTO();
        tourist.setFirstName(touristAddForm.getFirstName());
        tourist.setLastName(touristAddForm.getLastName());
        tourist.setGender(touristAddForm.isMale());
        tourist.setCountry(touristAddForm.getCountry());
        tourist.setNote(touristAddForm.getNote());
        tourist.setBirthDate(LocalDate.parse(touristAddForm.getBirthDate()));

        touristService.saveTourist(tourist);

        List<TouristDTO> tourists = touristService.getAllTourists();
        model.addAttribute("tourists", tourists);
        model.addAttribute("addTouristSuccessMsg",
                "Tourist was added successfully.");
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
            model.addAttribute("deleteTouristSuccessMsg",
                    "Tourist was deleted successfully.");
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
            model.addAttribute("deleteFlightFromTouristSuccessMsg",
                    "Flight was deleted successfully.");
            return "tourist/manage";
        }
        return "redirect:/tourist/manage/" + touristId;
    }

    @GetMapping("/flight/all")
    public String showAllAvailableFlightsPage(Model model) {
        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        List<FlightDTO> flightsList = flightService.getAllFlights();
        Map<Long, Boolean> hasFreePlaceMap = new HashMap<>();
        Map<Long, Boolean> isAlreadyBookedMap = new HashMap<>();

        for (int i = 0; i < flightsList.size(); i++) {
            // check if has free places
            hasFreePlaceMap.put(flightsList.get(i).getId(),
                    hasFreePlace(flightsList.get(i)));

            // check if already booked
            boolean isAlreadyBooked =
                    touristService.checkIfTouristBookedFlight(flightsList.get(i).getId(),
                            touristDTO.getId());
            isAlreadyBookedMap.put(flightsList.get(i).getId(), isAlreadyBooked);

        }

        model.addAttribute("tourist", touristDTO);
        model.addAttribute("isAlreadyBooked", isAlreadyBookedMap);
        model.addAttribute("hasFreePlace", hasFreePlaceMap);
        model.addAttribute("flights", flightsList);
        return "/tourist/flight/all";
    }

    private boolean hasFreePlace(FlightDTO flightDTO) {
        int amountOfTourists = flightService.getAmountOfTourists(flightDTO);
        return (amountOfTourists < flightDTO.getAmountOfSeats());
    }

    @GetMapping("/flight/add/{flightId:[0-9]+}")
    public String showAddFlightPage(@PathVariable Long flightId, Model model) {
        this.flightId = flightId;
        TouristDTO touristDTO = touristService.getTouristByID(touristId);
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        if (touristService.checkIfTouristBookedFlight(flightDTO.getId(),
                touristDTO.getId())) {
            return "redirect:/tourist/flight/all";
        }

        touristService.addTouristFlight(flightDTO.getId(), touristDTO.getId());

        model.addAttribute("tourist", touristDTO);
        model.addAttribute("addFlightToTouristSuccessMsg",
                "Flight was added successfully.");

        return "tourist/manage";
    }
}
