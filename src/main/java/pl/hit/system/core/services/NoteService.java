package pl.hit.system.core.services;

import pl.hit.system.data.repositories.NoteRepository;

public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
}
