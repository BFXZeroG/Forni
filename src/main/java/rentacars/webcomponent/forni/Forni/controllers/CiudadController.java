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
import rentacars.webcomponent.forni.Forni.models.Ciudad;
import rentacars.webcomponent.forni.Forni.repository.CiudadRepository;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
      @Autowired
    private CiudadRepository CiudadRepository;

    @GetMapping()
    public Iterable<Ciudad> list() {

        return CiudadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> get(@PathVariable String id) {
        Optional<Ciudad> aOptional = CiudadRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Ciudad aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> put(@PathVariable String id, @RequestBody Ciudad editarCiudad) {

        Optional<Ciudad> aOptional = CiudadRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Ciudad aEncontrado = aOptional.get();

            editarCiudad.setIdCiudad(aEncontrado.getIdCiudad());
            CiudadRepository.save(editarCiudad);
            return new ResponseEntity<>(editarCiudad, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Ciudad nuevoCiudad) {
        nuevoCiudad = CiudadRepository.save(nuevoCiudad);

        Optional<Ciudad> aOptional = CiudadRepository.findById(nuevoCiudad.getIdCiudad());

        if (aOptional.isPresent()) {
            Ciudad aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Ciudad> aOptional = CiudadRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Ciudad aEncontrado = aOptional.get();

            CiudadRepository.deleteById(aEncontrado.getIdCiudad());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
