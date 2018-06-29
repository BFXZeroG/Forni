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
import rentacars.webcomponent.forni.Forni.models.Arriendo;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    
    @GetMapping()
    public List<Arriendo> list() {
        return Arriendo.listaArriendo;
    }
    
    @GetMapping("/{id}")
    public Arriendo get(@PathVariable String id) {
        Arriendo A = new Arriendo();
        return A.buscaArriendo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Arriendo> put(@PathVariable String id, @RequestBody Arriendo editarArriendo) {
         Arriendo A = new Arriendo();
         
        return new ResponseEntity<>(A.editarArriendo(Integer.parseInt(id), editarArriendo),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Arriendo nuevoArriendo) {
        Arriendo A = new Arriendo();
        if (A.nuevaArriendo(nuevoArriendo)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Arriendo A = new Arriendo();
        
        if (A.eliminarArriendo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
