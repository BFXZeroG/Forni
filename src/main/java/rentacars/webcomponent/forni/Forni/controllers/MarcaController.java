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
import rentacars.webcomponent.forni.Forni.models.Marca;
import rentacars.webcomponent.forni.Forni.repository.MarcaRepository;
/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
@Autowired
    private MarcaRepository MarcaRepository;

    @GetMapping()
    public Iterable<Marca> list() {

        return MarcaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> get(@PathVariable String id) {
        Optional<Marca> aOptional = MarcaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Marca aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> put(@PathVariable String id, @RequestBody Marca editarMarca) {

        Optional<Marca> aOptional = MarcaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Marca aEncontrado = aOptional.get();

            editarMarca.setIdMarca(aEncontrado.getIdMarca());
            MarcaRepository.save(editarMarca);
            return new ResponseEntity<>(editarMarca, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Marca nuevoMarca) {
        nuevoMarca = MarcaRepository.save(nuevoMarca);

        Optional<Marca> aOptional = MarcaRepository.findById(nuevoMarca.getIdMarca());

        if (aOptional.isPresent()) {
            Marca aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Marca> aOptional = MarcaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Marca aEncontrado = aOptional.get();

            MarcaRepository.deleteById(aEncontrado.getIdMarca());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}

