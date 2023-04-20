package com.example.module_13;

import com.example.module_13.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Component
public class NoteServiceTest {
    private final NoteService noteService;

    @PostConstruct
    public void init(){

        Note note1 = new Note();
        note1.setTitle("Note 1");
        note1.setContent("Content of note 1");
        Note addedNote1 = noteService.add(note1);
        System.out.println("Added note: " + addedNote1);

        Note note2 = new Note();
        note2.setTitle("Note 2");
        note2.setContent("Content of note 2");
        Note addedNote2 = noteService.add(note2);
        System.out.println("Added note: " + addedNote2);

        List<Note> notes = noteService.listAll();
        System.out.println("All notes: " + notes);

        Note noteById = noteService.getById(addedNote1.getId());
        System.out.println("Note by id " + addedNote1.getId() + ": " + noteById);

        addedNote1.setTitle("New title for note 1");
        addedNote1.setContent("New content for note 1");
        noteService.update(addedNote1);
        System.out.println("Updated note: " + noteService.getById(addedNote1.getId()));

        noteService.deleteById(addedNote2.getId());
        System.out.println("All notes after deleting note with id " + addedNote2.getId() + ": " + noteService.listAll());
    }
}
