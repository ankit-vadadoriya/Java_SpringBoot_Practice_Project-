package com.example.Notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notes.entity.Notes;
import com.example.Notes.repository.NotesRepository;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public void saveNotes(Notes notes){
        notesRepository.save(notes);
    }

    public List<Notes> getAllNotes(){
        return notesRepository.findAll();
    }

    public void deleteNotesById(Long id){
        notesRepository.deleteById(id);
    }

    public Notes getNotesById(Long id){
        return notesRepository.findById(id).orElse(null);
    }


}
