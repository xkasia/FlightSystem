package pl.hit.system.dto;


import pl.hit.system.data.model.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TouristDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private String note;

    private LocalDate birthDate;

    private List<Flight> flightsList = new ArrayList<>();

    public TouristDTO() {
    }

    public Long getId() {
        return id;
    }

    public TouristDTO(String firstName, String lastName, String country, String note, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.note = note;
        this.birthDate = birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Flight> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(List<Flight> flightsList) {
        this.flightsList = flightsList;
    }

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
