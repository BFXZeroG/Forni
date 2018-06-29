/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.models;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gerardo
 */
@Entity
@Table(name = "arriendo")
public class Marca {
    private int idMarca;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombreMarca;
    private String detalle;



    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Marca() {
    }

    public Marca(String nombreMarca, String detalle) {
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

    private Marca(int idMarca, String nombreMarca, String detalle) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

}
