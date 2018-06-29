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
import rentacars.webcomponent.forni.Forni.models.Devolucion;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @GetMapping()
    public List<Devolucion> list() {
        return Devolucion.listaDevolucion;
    }
    
    @GetMapping("/{id}")
    public Devolucion get(@PathVariable String id) {
        Devolucion D = new Devolucion();
        return D.buscaDevolucion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Devolucion> put(@PathVariable String id, @RequestBody Devolucion editarDevolucion) {
         Devolucion D = new Devolucion();
         
        return new ResponseEntity<>(D.editarDevolucion(Integer.parseInt(id), editarDevolucion),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Devolucion nuevoDevolucion) {
       Devolucion D = new Devolucion();
        if (D.nuevaDevolucion(nuevoDevolucion)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         Devolucion D = new  Devolucion();
        
        if (D.eliminarDevolucion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
