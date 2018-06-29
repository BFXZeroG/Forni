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
import rentacars.webcomponent.forni.Forni.models.Arriendo;
import rentacars.webcomponent.forni.Forni.repository.ArriendoRepository;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {

    @Autowired
    private ArriendoRepository arriendoRepository;

    @GetMapping()
    public Iterable<Arriendo> list() {

        return arriendoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arriendo> get(@PathVariable String id) {
        Optional<Arriendo> aOptional = arriendoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Arriendo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arriendo> put(@PathVariable String id, @RequestBody Arriendo editarArriendo) {

        Optional<Arriendo> aOptional = arriendoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Arriendo aEncontrado = aOptional.get();

            editarArriendo.setIdArriendo(aEncontrado.getIdArriendo());
            arriendoRepository.save(editarArriendo);
            return new ResponseEntity<>(editarArriendo, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Arriendo nuevoArriendo) {
        nuevoArriendo = arriendoRepository.save(nuevoArriendo);

        Optional<Arriendo> aOptional = arriendoRepository.findById(nuevoArriendo.getIdArriendo());

        if (aOptional.isPresent()) {
            Arriendo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Arriendo> aOptional = arriendoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Arriendo aEncontrado = aOptional.get();

            arriendoRepository.deleteById(aEncontrado.getIdArriendo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }

}
