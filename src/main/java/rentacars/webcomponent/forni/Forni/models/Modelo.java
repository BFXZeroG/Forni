/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.models;

import rentacars.webcomponent.forni.Forni.models.Marca;
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
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModelo;
    private String nombreModelo;
    private String detalle;
    @ManyToOne
    @JoinColumn(name = "id_tipo_marca")
    private Marca marca;

    public static ArrayList<Modelo> listaModelo = new ArrayList<>();

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo() {
    }

    public Modelo(String nombreModelo, String detalle, Marca marca) {
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    private Modelo(int idModelo, String nombreModelo, String detalle, Marca marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    public boolean nuevaModelo(Modelo nuevaModelo) {

        int id = 0;

        if (!listaModelo.isEmpty()) {

            for (Modelo Mo : listaModelo) {
                if (Mo.getIdModelo() > id) {
                    id = Mo.getIdModelo();
                }
            }

        }

        id++;

        listaModelo.add(new Modelo(id, nuevaModelo.getNombreModelo(), nuevaModelo.getDetalle(), nuevaModelo.getMarca()));

        return true;
    }

    public Modelo buscaModelo(int idModeloBuscada) {

        Modelo modeloEncontrado = null;

        if (!listaModelo.isEmpty()) {
            for (Modelo Mo : listaModelo) {
                if (Mo.getIdModelo() == idModeloBuscada) {
                    modeloEncontrado = Mo;
                }
            }
        }

        return modeloEncontrado;

    }

    public Modelo editarModelo(int idModelo, Modelo modeloEditar) {

        Modelo modeloEditada = null;

        if (!listaModelo.isEmpty()) {
            for (Modelo Mo : listaModelo) {
                if (Mo.getIdModelo() == idModelo) {
                    Mo.setNombreModelo(modeloEditar.getNombreModelo());
                    Mo.setDetalle(modeloEditar.getDetalle());

                    modeloEditada = Mo;
                }
            }
        }

        return modeloEditada;

    }

    public boolean eliminarModelo(int id) {
        Modelo modeloEliminada = null;

        if (!listaModelo.isEmpty()) {
            for (Modelo Mo : listaModelo) {
                if (Mo.getIdModelo() == id) {
                    modeloEliminada = Mo;
                }
            }
        }

        listaModelo.remove(modeloEliminada);

        return true;
    }

}
