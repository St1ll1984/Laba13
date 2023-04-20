package com.example.module_13.controller;

import com.example.module_13.model.Note;
import com.example.module_13.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/note/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "listNotes";
    }

    @PostMapping("/note/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/note/edit")
    public String showEditForm(@RequestParam("id") long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/note/edit")
    public String editNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/note/add")
    public String add(Model model) {
        model.addAttribute("note", new Note());
        return "add";
    }

    @PostMapping("/note/add")
    public String add(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }
}