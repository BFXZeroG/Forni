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
 * @author 20076697-0
 */
@Entity
@Table(name = "combustible")
public class Combustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCombustible;
    private String tipoCombustible;
    private String detalle;

    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Combustible() {
    }

    public Combustible(String tipoCombustible, String detalle) {
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

    private Combustible(int idCombustible, String tipoCombustible, String detalle) {
        this.idCombustible = idCombustible;
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

}
