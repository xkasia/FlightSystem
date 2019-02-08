package pl.hit.system.data.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tourists")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name", length = 50, columnDefinition = "VARCHAR")
    private String firstName;

    @Column(nullable = false, name = "last_name", length = 100, columnDefinition = "VARCHAR")
    private String lastName;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR")
    private String country;

    @OneToMany(mappedBy = "tourist")
    private List<Note> notes = new ArrayList<>();

    @Column(name = "birth_date", nullable = false)
    private Timestamp birthDate;

    @ManyToMany(mappedBy = "touristList")
    private List<Flight> flightsList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tourist tourist = (Tourist) o;
        return Objects.equals(id, tourist.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }




}
