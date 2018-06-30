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
import rentacars.webcomponent.forni.Forni.models.MedioPago;
import rentacars.webcomponent.forni.Forni.repository.MedioPagoRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/medioPago")
public class MedioPagoController {
    
    @Autowired
    private MedioPagoRepository MedioPagoRepository;

    @GetMapping()
    public Iterable<MedioPago> list() {

        return MedioPagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedioPago> get(@PathVariable String id) {
        Optional<MedioPago> aOptional = MedioPagoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedioPago> put(@PathVariable String id, @RequestBody MedioPago editarMedioPago) {

        Optional<MedioPago> aOptional = MedioPagoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();

            editarMedioPago.setIdMedioPago(aEncontrado.getIdMedioPago());
            MedioPagoRepository.save(editarMedioPago);
            return new ResponseEntity<>(editarMedioPago, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPago nuevoMedioPago) {
        nuevoMedioPago = MedioPagoRepository.save(nuevoMedioPago);

        Optional<MedioPago> aOptional = MedioPagoRepository.findById(nuevoMedioPago.getIdMedioPago());

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<MedioPago> aOptional = MedioPagoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();

            MedioPagoRepository.deleteById(aEncontrado.getIdMedioPago());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
}
