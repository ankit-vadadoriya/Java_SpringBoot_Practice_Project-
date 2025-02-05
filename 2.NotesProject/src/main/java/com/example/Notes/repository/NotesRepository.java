package com.example.Notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Notes.entity.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
        
}
