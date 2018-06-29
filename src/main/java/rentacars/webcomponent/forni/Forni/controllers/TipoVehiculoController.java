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
import rentacars.webcomponent.forni.Forni.models.TipoVehiculo;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoController {
    
     @GetMapping()
    public List<TipoVehiculo> list() {
        return TipoVehiculo.listaTipoVehiculo;
    }
      @GetMapping("/{id}")
    public TipoVehiculo get(@PathVariable String id) {
        TipoVehiculo Tv = new TipoVehiculo();
        return Tv.buscaTipoVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculo> put(@PathVariable String id, @RequestBody TipoVehiculo editarTipoVehiculo) {
         TipoVehiculo Tv = new TipoVehiculo();
         
        return new ResponseEntity<>(Tv.editarTipoVehiculo(Integer.parseInt(id), editarTipoVehiculo),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculo nuevoTipoVehiculo) {
        TipoVehiculo Tv = new TipoVehiculo();
        if (Tv.nuevaTipoVehiculo(nuevoTipoVehiculo)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TipoVehiculo Tv = new TipoVehiculo();
        
        if (Tv.eliminarTipoVehiculo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
    
}
