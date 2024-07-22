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


import com.example.demo.model.Prenotazione;

import com.example.demo.repository.PrenotazioneRepository;

import jakarta.validation.Valid;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/reservations")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	// Get all reservations
	@GetMapping
	public List<Prenotazione> getAllPrenotazioni() {
		return prenotazioneRepository.findAll();
	}

	// Get reservation by ID
	@GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        if (prenotazione.isPresent()) {
            return new ResponseEntity<>(prenotazione.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/count")
	public ResponseEntity<Long> countPrenotazioni() {
	    long count = prenotazioneRepository.count();
	    return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	// Create a new prenotazione
	@PostMapping
    public ResponseEntity<Prenotazione> createPrenotazione(@Valid @RequestBody Prenotazione prenotazione) {
        Prenotazione savedPrenotazione = prenotazioneRepository.save(prenotazione);
        return new ResponseEntity<>(savedPrenotazione, HttpStatus.CREATED);
    }
	


	

	// Update a destination by ID
	@PutMapping("/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable Long id, @Valid @RequestBody Prenotazione prenotazione) {
        Optional<Prenotazione> existingPrenotazione = prenotazioneRepository.findById(id);
        if (existingPrenotazione.isPresent()) {
            prenotazione.setId(id);
            Prenotazione updatedPrenotazione = prenotazioneRepository.save(prenotazione);
            return new ResponseEntity<>(updatedPrenotazione, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	// Delete a destination by ID
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        if (prenotazioneRepository.existsById(id)) {
            prenotazioneRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
