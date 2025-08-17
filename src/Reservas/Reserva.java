/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;

import Clientes.Cliente;
import Vehiculos.Vehiculos;
import java.time.LocalDate;
import Utils.UtilFecha;

/**
 *
 * @author josep
 */
public class Reserva {
    private String idReserva;
    private Cliente clientes;
    private Vehiculos vehiculos;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private boolean activo;

    public Reserva(String idReserva, Cliente clientes, Vehiculos vehiculos, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.idReserva = idReserva;
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.activo = true;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Cliente getClientes() {
        return clientes;
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

    public boolean isActivo() {
        return activo;
    }
    
    public void cancelar() {
      this.activo = false;
    }

    @Override
    public String toString() {
        return "Reserva: " + "idReserva=" + idReserva + ", clientes=" + clientes + ", vehiculos=" + vehiculos + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", activo=" + activo;
    }
    
}