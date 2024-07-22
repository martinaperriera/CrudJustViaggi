package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destinazione;
import com.example.demo.service.DestinazioneService;

import jakarta.validation.Valid;

@CrossOrigin 
@Validated
@RestController
@RequestMapping("/api/destinazioni")
public class DestinazioneController {

    @Autowired
    private DestinazioneService destinazioneService;

    // Get all destinations
    @GetMapping
    public List<Destinazione> getAllDestinazioni() {
        return destinazioneService.getAllDestinazioni();
    }

    // Get a destination by ID
    @GetMapping("/{id}")
    public ResponseEntity<Destinazione> getDestinazioneById(@PathVariable Long id) {
        Optional<Destinazione> destinazione = destinazioneService.getDestinazioneById(id);
        return destinazione.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new destination
    @PostMapping
    public ResponseEntity<Destinazione> createDestinazione(@Valid @RequestBody Destinazione destinazione) {
        Destinazione savedDestinazione = destinazioneService.createDestinazione(destinazione);
        return new ResponseEntity<>(savedDestinazione, HttpStatus.CREATED);
    }

    // Update a destination by ID
    @PutMapping("/{id}")
    public ResponseEntity<Destinazione> updateDestinazione(@PathVariable Long id, @Valid @RequestBody Destinazione destinazione) {
        Optional<Destinazione> updatedDestinazione = destinazioneService.updateDestinazione(id, destinazione);
        return updatedDestinazione.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a destination by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestinazione(@PathVariable Long id) {
        boolean isDeleted = destinazioneService.deleteDestinazione(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                         : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}