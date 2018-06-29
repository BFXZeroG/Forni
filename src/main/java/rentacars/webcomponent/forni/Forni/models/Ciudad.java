/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.models;

import rentacars.webcomponent.forni.Forni.models.Region;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gerardo
 */
@Entity
@Table(name = "ciudad")

public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudad;
    private String nombreCiudad;
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region Region;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Region getRegion() {
        return Region;
    }

    public void setRegion(Region Region) {
        this.Region = Region;
    }

    public Ciudad() {
    }

    public Ciudad(String nombreCiudad, String detalle, Region Region) {
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.Region = Region;
    }

    private Ciudad(int idCiudad, String nombreCiudad, String detalle, Region Region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.Region = Region;
    }

}
