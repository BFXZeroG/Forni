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
import rentacars.webcomponent.forni.Forni.models.Vehiculo;
import rentacars.webcomponent.forni.Forni.repository.VehiculoRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    
  @Autowired
    private VehiculoRepository VehiculoRepository;

    @GetMapping()
    public Iterable<Vehiculo> list() {

        return VehiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> get(@PathVariable String id) {
        Optional<Vehiculo> aOptional = VehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> put(@PathVariable String id, @RequestBody Vehiculo editarVehiculo) {

        Optional<Vehiculo> aOptional = VehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();

            editarVehiculo.setIdVehiculo(aEncontrado.getIdVehiculo());
            VehiculoRepository.save(editarVehiculo);
            return new ResponseEntity<>(editarVehiculo, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Vehiculo nuevoVehiculo) {
        nuevoVehiculo = VehiculoRepository.save(nuevoVehiculo);

        Optional<Vehiculo> aOptional = VehiculoRepository.findById(nuevoVehiculo.getIdVehiculo());

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Vehiculo> aOptional = VehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();

          VehiculoRepository.deleteById(aEncontrado.getIdVehiculo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
}
