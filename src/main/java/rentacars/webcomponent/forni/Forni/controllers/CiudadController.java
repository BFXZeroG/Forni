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
import rentacars.webcomponent.forni.Forni.models.Ciudad;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
   @GetMapping()
    public List<Ciudad> list() {
        return Ciudad.listaCiudad;
    }
    
    @GetMapping("/{id}")
    public Ciudad get(@PathVariable String id) {
        Ciudad Ci = new Ciudad();
        return Ci.buscaCiudad(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> put(@PathVariable String id, @RequestBody Ciudad editarCiudad) {
         Ciudad Ci = new Ciudad();
         
        return new ResponseEntity<>(Ci.editarCiudad(Integer.parseInt(id), editarCiudad),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Ciudad nuevoCiudad) {
        Ciudad Ci = new Ciudad();
        if (Ci.nuevaCiudad(nuevoCiudad)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Ciudad Ci = new Ciudad();
        
        if (Ci.eliminarCiudad(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
