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
import rentacars.webcomponent.forni.Forni.models.Version;

/**
 *
 * @author mxrni
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    
     @GetMapping()
    public List<Version> list() {
        return Version.listaVersion;
    }
    @GetMapping("/{id}")
    public Version get(@PathVariable String id) {
        Version Vr = new Version();
        return Vr.buscaVersion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Version> put(@PathVariable String id, @RequestBody Version editarVersion) {
         Version Vr = new Version();
         
        return new ResponseEntity<>(Vr.editarVersion(Integer.parseInt(id), editarVersion),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Version nuevoVersion) {
        Version Vr = new Version();
        if (Vr.nuevaVersion(nuevoVersion)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Version Vr = new Version();
        
        if (Vr.eliminarVersion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        
        
    }
    
}
