/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacars.webcomponent.forni.Forni.models.Vehiculo;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    
       @GetMapping()
    public List<Vehiculo> list() {
        return Vehiculo.listaVehiculo;
    }
    @GetMapping("/{id}")
    public Vehiculo get(@PathVariable String id) {
        Vehiculo Ve = new Vehiculo();
        return Ve.buscaVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> put(@PathVariable String id, @RequestBody Vehiculo editarVehiculo) {
         Vehiculo Ve = new Vehiculo();
         
        return new ResponseEntity<>(Ve.editarVehiculo(Integer.parseInt(id), editarVehiculo),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Vehiculo nuevoTipoPersona) {
        Vehiculo Ve = new Vehiculo();
        if (Ve.nuevaVehiculo(nuevoTipoPersona)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Vehiculo Ve = new Vehiculo();
        
        if (Ve.eliminarVehiculo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
}
