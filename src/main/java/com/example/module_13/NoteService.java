package com.example.module_13;

import com.example.module_13.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        Long id = random.nextLong();
        note.setId(id);
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        boolean removed = notes.removeIf(n -> n.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
    }

    public void update(Note note) {
        Note existingNote = getById(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        return notes.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }
}