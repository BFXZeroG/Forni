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
import rentacars.webcomponent.forni.Forni.models.Transmision;
import rentacars.webcomponent.forni.Forni.repository.TransmisionRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
      @Autowired
    private TransmisionRepository TransmisionRepository;

    @GetMapping()
    public Iterable<Transmision> list() {

        return TransmisionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transmision> get(@PathVariable String id) {
        Optional<Transmision> aOptional = TransmisionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Transmision aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transmision> put(@PathVariable String id, @RequestBody Transmision editarTransmision) {

        Optional<Transmision> aOptional = TransmisionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Transmision aEncontrado = aOptional.get();

            editarTransmision.setIdTransmision(aEncontrado.getIdTransmision());
            TransmisionRepository.save(editarTransmision);
            return new ResponseEntity<>(editarTransmision, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transmision nuevoTransmision) {
        nuevoTransmision = TransmisionRepository.save(nuevoTransmision);

        Optional<Transmision> aOptional = TransmisionRepository.findById(nuevoTransmision.getIdTransmision());

        if (aOptional.isPresent()) {
            Transmision aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Transmision> aOptional = TransmisionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Transmision aEncontrado = aOptional.get();

            TransmisionRepository.deleteById(aEncontrado.getIdTransmision());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
}
