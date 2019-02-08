package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hit.system.data.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
