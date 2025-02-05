package com.example.Notes.controller;


import com.example.Notes.entity.Notes;
import com.example.Notes.services.NotesService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




// @RestController
@Controller
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping("/notes")
    public String homePage(Model model) {
        model.addAttribute("allNotes", notesService.getAllNotes());
        return "notes";
    }

    @GetMapping("/addNotes")
    public String showAddNotesPage(Model model) {
        model.addAttribute("notes", new Notes());
        return "addNotes"; 
    }

    //action on add Note button click
    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute Notes notes) {
        notesService.saveNotes(notes);
        return "redirect:/notes";
    }

    @PostMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable Long id) {
        notesService.deleteNotesById(id);
        return "redirect:/notes";
    }

    @GetMapping("/editNote/{id}")
    public String showEditNotPage(@PathVariable Long id, Model model) {
        Notes note = notesService.getNotesById(id);
        model.addAttribute("note", note);
        return "editNote";
    }
    
    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute Notes note) {
        notesService.saveNotes(note);
        return "redirect:/notes";
    }
    

}
