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
@Table(name = "transmision")
public class Transmision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransmision;
    private String nombreTransmision;
    private String detalle;

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Transmision() {
    }

    public Transmision(String nombreTransmision, String detalle) {
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }

    private Transmision(int idTransmision, String nombreTransmision, String detalle) {
        this.idTransmision = idTransmision;
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }

}
