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
@Table(name = "tipo_persona")
public class TipoPersona {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPersona;
    private String nombreTipoPersona;
    private String detalle;



    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoPersona() {
    }

    public TipoPersona(String nombreTipoPersona, String detalle) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    private TipoPersona(int idTipoPersona, String nombreTipoPersona, String detalle) {
        this.idTipoPersona = idTipoPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

}
