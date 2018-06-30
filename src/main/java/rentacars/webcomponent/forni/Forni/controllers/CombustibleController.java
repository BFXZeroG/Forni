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
import rentacars.webcomponent.forni.Forni.models.Combustible;
import rentacars.webcomponent.forni.Forni.repository.CombustibleRepository;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/combustible")
public class CombustibleController {
    
@Autowired
    private CombustibleRepository CombustibleRepository;

    @GetMapping()
    public Iterable<Combustible> list() {

        return CombustibleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combustible> get(@PathVariable String id) {
        Optional<Combustible> aOptional = CombustibleRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Combustible aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combustible> put(@PathVariable String id, @RequestBody Combustible editarCombustible) {

        Optional<Combustible> aOptional = CombustibleRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Combustible aEncontrado = aOptional.get();

            editarCombustible.setIdCombustible(aEncontrado.getIdCombustible());
            CombustibleRepository.save(editarCombustible);
            return new ResponseEntity<>(editarCombustible, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Combustible nuevoCombustible) {
        nuevoCombustible = CombustibleRepository.save(nuevoCombustible);

        Optional<Combustible> aOptional = CombustibleRepository.findById(nuevoCombustible.getIdCombustible());

        if (aOptional.isPresent()) {
            Combustible aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Combustible> aOptional = CombustibleRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Combustible aEncontrado = aOptional.get();

           CombustibleRepository.deleteById(aEncontrado.getIdCombustible());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
