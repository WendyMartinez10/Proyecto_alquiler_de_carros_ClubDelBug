/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrato;

import Clientes.Cliente;
import Reservas.Reserva;
import Vehiculos.Vehiculos;
import java.time.LocalDate;

/**
 *
 * @author josep
 */
public class Contratos {
    private String idContrato;
    private Reserva reserva;
    private Cliente cliente;
    private Vehiculos vehiculos;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private double monto;
    private boolean activo;

    public Contratos(String idContrato, Reserva reserva, Cliente cliente, Vehiculos vehiculos, LocalDate fechaInicio, LocalDate fechaFinal, double monto) {
        this.idContrato = idContrato;
        this.reserva = reserva;
        this.cliente = cliente;
        this.vehiculos = vehiculos;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.monto = monto;
        this.activo = true;
    }

  

    public String getIdContrato() {
        return idContrato;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isActivo() {
        if (activo) {
        return true;
    } else {
        return false;
    }
    }

    @Override
    public String toString() {
        return "Contratos: " + "idContrato=" + idContrato + ", reserva=" + reserva + ", cliente=" + cliente + ", vehiculos=" + vehiculos + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", monto=" + monto + ", activo=" + activo;
    }
    
    
}
