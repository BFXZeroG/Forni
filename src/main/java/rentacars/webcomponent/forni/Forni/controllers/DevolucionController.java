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
import rentacars.webcomponent.forni.Forni.models.Devolucion;
import rentacars.webcomponent.forni.Forni.repository.DevolucionRepository;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
   @Autowired
    private DevolucionRepository DevolucionRepository;

    @GetMapping()
    public Iterable<Devolucion> list() {

        return DevolucionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> get(@PathVariable String id) {
        Optional<Devolucion> aOptional = DevolucionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devolucion> put(@PathVariable String id, @RequestBody Devolucion editarDevolucion) {

        Optional<Devolucion> aOptional = DevolucionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();

            editarDevolucion.setIdDevolucion(aEncontrado.getIdDevolucion());
            DevolucionRepository.save(editarDevolucion);
            return new ResponseEntity<>(editarDevolucion, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Devolucion nuevoDevolucion) {
        nuevoDevolucion = DevolucionRepository.save(nuevoDevolucion);

        Optional<Devolucion> aOptional = DevolucionRepository.findById(nuevoDevolucion.getIdDevolucion());

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Devolucion> aOptional = DevolucionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();

            DevolucionRepository.deleteById(aEncontrado.getIdDevolucion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
