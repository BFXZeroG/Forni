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
import rentacars.webcomponent.forni.Forni.models.Version;
import rentacars.webcomponent.forni.Forni.repository.VersionRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    
      @Autowired
    private VersionRepository VersionRepository;

    @GetMapping()
    public Iterable<Version> list() {

        return VersionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Version> get(@PathVariable String id) {
        Optional<Version> aOptional = VersionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Version aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Version> put(@PathVariable String id, @RequestBody Version editarVersion) {

        Optional<Version> aOptional = VersionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Version aEncontrado = aOptional.get();

            editarVersion.setIdVersion(aEncontrado.getIdVersion());
            VersionRepository.save(editarVersion);
            return new ResponseEntity<>(editarVersion, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Version nuevoVersion) {
        nuevoVersion = VersionRepository.save(nuevoVersion);

        Optional<Version> aOptional = VersionRepository.findById(nuevoVersion.getIdVersion());

        if (aOptional.isPresent()) {
            Version aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Version> aOptional = VersionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
          Version aEncontrado = aOptional.get();

            VersionRepository.deleteById(aEncontrado.getIdVersion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
