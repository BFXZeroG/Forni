/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.repository;

import org.springframework.data.repository.CrudRepository;
import rentacars.webcomponent.forni.Forni.models.Ciudad;
/**
 *
 * @author mxrni
 */
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {
    
}
