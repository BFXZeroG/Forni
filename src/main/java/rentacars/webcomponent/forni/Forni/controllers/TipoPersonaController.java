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
import rentacars.webcomponent.forni.Forni.models.TipoPersona;
import rentacars.webcomponent.forni.Forni.repository.TipoPersonaRepository;
 

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/tipoPersona")
public class TipoPersonaController {
    
  @Autowired
    private TipoPersonaRepository TipoPersonaRepository;

    @GetMapping()
    public Iterable<TipoPersona> list() {

        return TipoPersonaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> get(@PathVariable String id) {
        Optional<TipoPersona> aOptional = TipoPersonaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoPersona aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersona> put(@PathVariable String id, @RequestBody TipoPersona editarTipoPersona) {

        Optional<TipoPersona> aOptional = TipoPersonaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoPersona aEncontrado = aOptional.get();

            editarTipoPersona.setIdTipoPersona(aEncontrado.getIdTipoPersona());
            TipoPersonaRepository.save(editarTipoPersona);
            return new ResponseEntity<>(editarTipoPersona, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersona nuevoTipoPersona) {
        nuevoTipoPersona = TipoPersonaRepository.save(nuevoTipoPersona);

        Optional<TipoPersona> aOptional = TipoPersonaRepository.findById(nuevoTipoPersona.getIdTipoPersona());

        if (aOptional.isPresent()) {
            TipoPersona aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoPersona> aOptional = TipoPersonaRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoPersona aEncontrado = aOptional.get();

           TipoPersonaRepository.deleteById(aEncontrado.getIdTipoPersona());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
