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
@Table(name = "tipo_vehiculo")
public class TipoVehiculo {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalle;


    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoVehiculo() {
    }

    public TipoVehiculo(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    private TipoVehiculo(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

   
}
