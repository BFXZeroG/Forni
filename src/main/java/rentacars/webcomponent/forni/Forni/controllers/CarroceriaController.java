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
import rentacars.webcomponent.forni.Forni.models.Carroceria;

/**
 *
 * @author Gerardo
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {

    @GetMapping()
    public List<Carroceria> list() {
        return Carroceria.listaCarroceria;
    }

    @GetMapping("/{id}")
    public Carroceria get(@PathVariable String id) {
        Carroceria C = new Carroceria();
        return  C.buscaCarroceria(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carroceria> put(@PathVariable String id, @RequestBody Carroceria editarCarroceria) {
        Carroceria C = new Carroceria();
        return new ResponseEntity<>(C.editarCarroceria(Integer.parseInt(id), editarCarroceria), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Carroceria nuevoCarroceria) {
        Carroceria C = new Carroceria();
        if (C.nuevaCarroceria(nuevoCarroceria)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else  return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Carroceria C = new Carroceria();
        
        if (C.eliminarCarroceria(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

}
