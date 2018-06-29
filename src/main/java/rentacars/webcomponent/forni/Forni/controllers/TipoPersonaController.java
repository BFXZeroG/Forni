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
import rentacars.webcomponent.forni.Forni.models.TipoPersona;
 

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/tipoPersona")
public class TipoPersonaController {
    
    
      @GetMapping()
    public List<TipoPersona> list() {
        return TipoPersona.listaTipoPersona;
    }
    @GetMapping("/{id}")
    public TipoPersona get(@PathVariable String id) {
        TipoPersona Tp = new TipoPersona();
        return Tp.buscaTipoPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersona> put(@PathVariable String id, @RequestBody TipoPersona editarTipoPersona) {
         TipoPersona Tp = new TipoPersona();
         
        return new ResponseEntity<>(Tp.editarTipoPersona(Integer.parseInt(id), editarTipoPersona),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersona nuevoTipoPersona) {
        TipoPersona Tp = new TipoPersona();
        if (Tp.nuevaTipoPersona(nuevoTipoPersona)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TipoPersona Tp = new TipoPersona();
        
        if (Tp.eliminarTipoPersona(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
