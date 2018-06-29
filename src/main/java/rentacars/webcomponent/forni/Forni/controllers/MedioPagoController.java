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
import rentacars.webcomponent.forni.Forni.models.MedioPago;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/medioPago")
public class MedioPagoController {
    
    @GetMapping()
    public List<MedioPago> list() {
        return MedioPago.listaMedioPago;
    }
    
    @GetMapping("/{id}")
    public MedioPago get(@PathVariable String id) {
        MedioPago Mp = new MedioPago();
        return Mp.buscaMedioPago(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPago> put(@PathVariable String id, @RequestBody MedioPago editarMedioPago) {
         MedioPago Mp = new MedioPago();
         
        return new ResponseEntity<>(Mp.editarMedioPago(Integer.parseInt(id), editarMedioPago),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPago nuevoMedioPago) {
        MedioPago Mp = new MedioPago();
        if (Mp.nuevaMedioPago(nuevoMedioPago)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MedioPago Mp = new MedioPago();
        
        if (Mp.eliminarMedioPago(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
}
