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
import rentacars.webcomponent.forni.Forni.models.Persona;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @GetMapping()
    public List<Persona> list() {
        return Persona.listaPersona;
    }
    
    @GetMapping("/{id}")
    public Persona get(@PathVariable String id) {
        Persona Pe = new Persona();
        return Pe.buscaPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Persona> put(@PathVariable String id, @RequestBody Persona editarPersona) {
         Persona Pe = new Persona();
         
        return new ResponseEntity<>(Pe.editarPersona(Integer.parseInt(id), editarPersona),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Persona nuevoPersona) {
        Persona Pe = new Persona();
        if (Pe.nuevaPersona(nuevoPersona)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Persona Pe = new Persona();
        
        if (Pe.eliminarPersona(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
