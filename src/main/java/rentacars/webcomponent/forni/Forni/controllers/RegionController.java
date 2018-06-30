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
import rentacars.webcomponent.forni.Forni.models.Region;
import rentacars.webcomponent.forni.Forni.repository.RegionRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
    @Autowired
    private RegionRepository RegionRepository;

    @GetMapping()
    public Iterable<Region> list() {

        return RegionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> get(@PathVariable String id) {
        Optional<Region> aOptional = RegionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Region aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> put(@PathVariable String id, @RequestBody Region editarRegion) {

        Optional<Region> aOptional = RegionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Region aEncontrado = aOptional.get();

            editarRegion.setIdRegion(aEncontrado.getIdRegion());
            RegionRepository.save(editarRegion);
            return new ResponseEntity<>(editarRegion, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Region nuevoRegion) {
        nuevoRegion = RegionRepository.save(nuevoRegion);

        Optional<Region> aOptional = RegionRepository.findById(nuevoRegion.getIdRegion());

        if (aOptional.isPresent()) {
            Region aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Region> aOptional = RegionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Region aEncontrado = aOptional.get();

            RegionRepository.deleteById(aEncontrado.getIdRegion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
}
