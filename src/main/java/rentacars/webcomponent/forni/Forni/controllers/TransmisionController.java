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
import rentacars.webcomponent.forni.Forni.models.Transmision;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
       @GetMapping()
    public List<Transmision> list() {
        return Transmision.listaTransmision;
    }
    @GetMapping("/{id}")
    public Transmision get(@PathVariable String id) {
        Transmision Ts = new Transmision();
        return Ts.buscaTransmision(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Transmision> put(@PathVariable String id, @RequestBody Transmision editarTransmision) {
         Transmision Ts = new Transmision();
         
        return new ResponseEntity<>(Ts.editarTransmision(Integer.parseInt(id), editarTransmision),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transmision nuevoTransmision) {
        Transmision Ts = new Transmision();
        if (Ts.nuevaTransmision(nuevoTransmision)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Transmision Ts = new Transmision();
        
        if (Ts.eliminarTransmision(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
}
