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
import rentacars.webcomponent.forni.Forni.models.Traccion;
import rentacars.webcomponent.forni.Forni.repository.TraccionRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
  @Autowired
    private TraccionRepository TraccionRepository;

    @GetMapping()
    public Iterable<Traccion> list() {

        return TraccionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traccion> get(@PathVariable String id) {
        Optional<Traccion> aOptional = TraccionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traccion> put(@PathVariable String id, @RequestBody Traccion editarTraccion) {

        Optional<Traccion> aOptional = TraccionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();

            editarTraccion.setIdTraccion(aEncontrado.getIdTraccion());
            TraccionRepository.save(editarTraccion);
            return new ResponseEntity<>(editarTraccion, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Traccion nuevoTraccion) {
        nuevoTraccion = TraccionRepository.save(nuevoTraccion);

        Optional<Traccion> aOptional = TraccionRepository.findById(nuevoTraccion.getIdTraccion());

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Traccion> aOptional = TraccionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();

           TraccionRepository.deleteById(aEncontrado.getIdTraccion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
