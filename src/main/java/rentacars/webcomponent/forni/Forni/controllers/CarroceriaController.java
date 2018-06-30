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
import rentacars.webcomponent.forni.Forni.models.Carroceria;
import rentacars.webcomponent.forni.Forni.repository.CarroceriaRepository;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {

    @Autowired
    private CarroceriaRepository CarroceriaRepository;

    @GetMapping()
    public Iterable<Carroceria> list() {

        return CarroceriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carroceria> get(@PathVariable String id) {
        Optional<Carroceria> aOptional = CarroceriaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Carroceria aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carroceria> put(@PathVariable String id, @RequestBody Carroceria editarCarroceria) {

        Optional<Carroceria> aOptional = CarroceriaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Carroceria aEncontrado = aOptional.get();

            editarCarroceria.setIdCarroceria(aEncontrado.getIdCarroceria());
            CarroceriaRepository.save(editarCarroceria);
            return new ResponseEntity<>(editarCarroceria, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Carroceria nuevoCarroceria) {
        nuevoCarroceria = CarroceriaRepository.save(nuevoCarroceria);

        Optional<Carroceria> aOptional = CarroceriaRepository.findById(nuevoCarroceria.getIdCarroceria());

        if (aOptional.isPresent()) {
            Carroceria aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Carroceria> aOptional = CarroceriaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Carroceria aEncontrado = aOptional.get();

            CarroceriaRepository.deleteById(aEncontrado.getIdCarroceria());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }

}
