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
import rentacars.webcomponent.forni.Forni.models.Marca;
/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @GetMapping()
    public List<Marca> list() {
        return Marca.listaMarca;
    }
    
    @GetMapping("/{id}")
    public Marca get(@PathVariable String id) {
        Marca Ma = new Marca();
        return Ma.buscaMarca(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Marca> put(@PathVariable String id, @RequestBody Marca editarMarca) {
         Marca Ma = new Marca();
         
        return new ResponseEntity<>(Ma.editarMarca(Integer.parseInt(id), editarMarca),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Marca nuevoMarca) {
        Marca Ma = new Marca();
        if (Ma.nuevaMarca(nuevoMarca)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Marca Ma = new Marca();
        
        if (Ma.eliminarMarca(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}

