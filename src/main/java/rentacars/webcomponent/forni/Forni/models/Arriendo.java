/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacars.webcomponent.forni.Forni.models;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Generated;
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
@Table(name = "arriendo")
public class Arriendo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    @ManyToOne
    @JoinColumn(name = "id_tipo_vendedor")
    private Persona vendedor;
        @ManyToOne
    @JoinColumn(name = "id_tipo_cliente")
    private Persona cliente;
            @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo")
    private Vehiculo vehiculo;
                @ManyToOne
    @JoinColumn(name = "id_tipo_medio_pago")
    private MedioPago medioPago;


    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time getHoraArriendo() {
        return horaArriendo;
    }

    public void setHoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public Arriendo() {
    }

    public Arriendo(Date fechaArriendo, Time horaArriendo, Persona vendedor, Persona cliente, Vehiculo vehiculo, MedioPago medioPago) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    private Arriendo(int idArriendo, Date fechaArriendo, Time horaArriendo, Persona vendedor, Persona cliente, Vehiculo vehiculo, MedioPago medioPago) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }
    

    
    

}
