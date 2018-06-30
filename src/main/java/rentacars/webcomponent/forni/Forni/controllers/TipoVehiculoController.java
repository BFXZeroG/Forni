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
import rentacars.webcomponent.forni.Forni.models.TipoVehiculo;
import rentacars.webcomponent.forni.Forni.repository.TipoVehiculoRepository;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoController {
    
  @Autowired
    private TipoVehiculoRepository TipoVehiculoRepository;

    @GetMapping()
    public Iterable<TipoVehiculo> list() {

        return TipoVehiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculo> get(@PathVariable String id) {
        Optional<TipoVehiculo> aOptional = TipoVehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculo> put(@PathVariable String id, @RequestBody TipoVehiculo editarTipoVehiculo) {

        Optional<TipoVehiculo> aOptional = TipoVehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();

            editarTipoVehiculo.setIdTipoVehiculo(aEncontrado.getIdTipoVehiculo());
            TipoVehiculoRepository.save(editarTipoVehiculo);
            return new ResponseEntity<>(editarTipoVehiculo, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculo nuevoTipoVehiculo) {
        nuevoTipoVehiculo = TipoVehiculoRepository.save(nuevoTipoVehiculo);

        Optional<TipoVehiculo> aOptional = TipoVehiculoRepository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoVehiculo> aOptional = TipoVehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();

            TipoVehiculoRepository.deleteById(aEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
    
    
}
