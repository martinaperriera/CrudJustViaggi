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


import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

import jakarta.validation.Valid;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteRepository utenteRepository;

	@GetMapping
	public List<Utente> getAllUtenti() {
		return utenteRepository.findAll();
	}

	@GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id) {
        Optional<Utente> utente = utenteRepository.findById(id);
        if (utente.isPresent()) {
            return new ResponseEntity<>(utente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@PostMapping
    public ResponseEntity<Utente> createUtente(@Valid @RequestBody Utente utente) {
        Utente savedUtente = utenteRepository.save(utente);
        return new ResponseEntity<>(savedUtente, HttpStatus.CREATED);
    }

	
	@PutMapping("/{id}")
    public ResponseEntity<Utente> updateUtente(@PathVariable Long id, @Valid @RequestBody Utente utente) {
        Optional<Utente> existingUtente = utenteRepository.findById(id);
        if (existingUtente.isPresent()) {
            utente.setId(id);
            Utente updatedUtente = utenteRepository.save(utente);
            return new ResponseEntity<>(updatedUtente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable Long id) {
        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}