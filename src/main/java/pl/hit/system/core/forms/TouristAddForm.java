package pl.hit.system.core.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TouristAddForm {

    private Long id;

    @NotEmpty(message = "{firstName.notEmpty}")
    private String firstName;

    @NotEmpty(message = "{lastName.notEmpty}")
    private String lastName;

    @NotEmpty(message = "{country.notEmpty}")
    private String country;

    private String note;

    public Long getId() {
        return id;
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
}
