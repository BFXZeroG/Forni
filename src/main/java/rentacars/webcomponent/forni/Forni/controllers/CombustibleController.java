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
import rentacars.webcomponent.forni.Forni.models.Combustible;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/combustible")
public class CombustibleController {
    
   @GetMapping()
    public List<Combustible> list() {
        return Combustible.combustible;
    }
    
    @GetMapping("/{id}")
    public Combustible get(@PathVariable String id) {
        Combustible Co = new Combustible();
        return Co.buscaCombustible(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Combustible> put(@PathVariable String id, @RequestBody Combustible editarCombustible) {
         Combustible Co = new Combustible();
         
        return new ResponseEntity<>(Co.editarCombustible(Integer.parseInt(id), editarCombustible),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Combustible nuevoCombustible) {
        Combustible Co = new Combustible();
        if (Co.nuevocombustible(nuevoCombustible)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Combustible Co = new Combustible();
        
        if (Co.eliminarCombustible(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
