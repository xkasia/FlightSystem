package pl.hit.system.dto;

import pl.hit.system.data.model.Flight;
import pl.hit.system.data.model.Note;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TouristDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private List<Note> notes = new ArrayList<>();

    private Timestamp birthDate;

    private List<Flight> flightsList = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TouristDTO touristDTO = (TouristDTO) o;
        return Objects.equals(id, touristDTO.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
