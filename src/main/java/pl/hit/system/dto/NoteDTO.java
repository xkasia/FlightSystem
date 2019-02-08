package pl.hit.system.dto;

import pl.hit.system.data.model.Tourist;

import java.util.Objects;


public class NoteDTO {

    private Long id;

    private Tourist tourist;

    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDTO noteDTO = (NoteDTO) o;
        return Objects.equals(id, noteDTO.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
