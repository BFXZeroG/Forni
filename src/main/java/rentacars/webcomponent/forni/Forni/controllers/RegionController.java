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
import rentacars.webcomponent.forni.Forni.models.Region;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
   @GetMapping()
    public List<Region> list() {
        return Region.listaRegion;
    }
    
    @GetMapping("/{id}")
    public Region get(@PathVariable String id) {
        Region Re = new Region();
        return Re.buscaRegion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Region> put(@PathVariable String id, @RequestBody Region editarRegion) {
         Region Re = new Region();
         
        return new ResponseEntity<>(Re.editarRegion(Integer.parseInt(id), editarRegion),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Region nuevoRegion) {
        Region Re = new Region();
        if (Re.nuevaRegion(nuevoRegion)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Region Re = new Region();
        
        if (Re.eliminarRegion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
