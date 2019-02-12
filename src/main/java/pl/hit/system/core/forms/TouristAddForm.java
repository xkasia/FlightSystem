package pl.hit.system.core.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TouristAddForm {

    @NotEmpty(message = "{firstName.notEmpty}")
    @Length(max = 50, message = "{firstName.length}")
    private String firstName;

    @NotEmpty(message = "{lastName.notEmpty}")
    @Length(max = 100, message = "{lastName.length}")
    private String lastName;

    @NotNull(message = "{gender.notEmpty}")
    private Boolean gender;

    @NotEmpty(message = "{country.notEmpty}")
    @Length(max = 50, message = "{country.length}")
    private String country;

    @Length(max = 500, message = "{note.length}")
    private String note;

    @NotEmpty(message = "{birthDate.notEmpty}")
    private String birthDate;


    public TouristAddForm() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean isMale() {
        return gender;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "TouristAddForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", note='" + note + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
