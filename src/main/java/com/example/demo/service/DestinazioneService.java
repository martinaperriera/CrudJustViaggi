package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Destinazione;
import com.example.demo.repository.DestinazioneRepository;

@Service
public class DestinazioneService {

    @Autowired
    private DestinazioneRepository destinazioneRepository;

    public List<Destinazione> getAllDestinazioni() {
        return destinazioneRepository.findAll();
    }

    public Optional<Destinazione> getDestinazioneById(Long id) {
        return destinazioneRepository.findById(id);
    }

    public Destinazione createDestinazione(Destinazione destinazione) {
        return destinazioneRepository.save(destinazione);
    }

    public Optional<Destinazione> updateDestinazione(Long id, Destinazione destinazione) {
        if (destinazioneRepository.existsById(id)) {
            destinazione.setId(id);
            return Optional.of(destinazioneRepository.save(destinazione));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteDestinazione(Long id) {
        if (destinazioneRepository.existsById(id)) {
            destinazioneRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
