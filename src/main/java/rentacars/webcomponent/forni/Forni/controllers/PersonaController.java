/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacars.webcomponent.forni.Forni.models.Persona;
import rentacars.webcomponent.forni.Forni.repository.PersonaRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
@Autowired
    private PersonaRepository PersonaRepository;

    @GetMapping()
    public Iterable<Persona> list() {

        return PersonaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> get(@PathVariable String id) {
        Optional<Persona> aOptional = PersonaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Persona aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> put(@PathVariable String id, @RequestBody Persona editarPersona) {

        Optional<Persona> aOptional = PersonaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Persona aEncontrado = aOptional.get();

            editarPersona.setIdPersona(aEncontrado.getIdPersona());
            PersonaRepository.save(editarPersona);
            return new ResponseEntity<>(editarPersona, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Persona nuevoPersona) {
        nuevoPersona = PersonaRepository.save(nuevoPersona);

        Optional<Persona> aOptional = PersonaRepository.findById(nuevoPersona.getIdPersona());

        if (aOptional.isPresent()) {
            Persona aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Persona> aOptional = PersonaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Persona aEncontrado = aOptional.get();

            PersonaRepository.deleteById(aEncontrado.getIdPersona());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
