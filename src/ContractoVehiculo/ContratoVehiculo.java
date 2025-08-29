/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContractoVehiculo;

import Clases.Vehiculo;
import Clientes.Cliente;
import Empleados.Empleado;
import java.time.LocalDate;
/**
 *
 * @author wen
 */
public class ContratoVehiculo {
    private static int idContrato = 0;
    private int numeroContrato;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Empleado empleado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double monto;
    private String estado; 

    public ContratoVehiculo(Cliente cliente, Vehiculo vehiculo, Empleado empleado,
                            LocalDate fechaInicio, LocalDate fechaFin, double tarifaDiaria) {
        this.numeroContrato = ++idContrato;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = tarifaDiaria * (fechaFin.getDayOfYear() - fechaInicio.getDayOfYear());
        this.estado = "Activo";
    }

    public void finalizar() { this.estado = "Finalizado"; }
    public void cancelar() { this.estado = "Cancelado"; }

    public static int getIdContrato() {
        return idContrato;
    }

    public static void setIdContrato(int idContrato) {
        ContratoVehiculo.idContrato = idContrato;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    

    public String mostrarInfo() {
        return "Contrato #" + numeroContrato +
               " | Cliente: " + cliente.nombre +
               " | Vehículo: " + vehiculo.getPlaca() +
               " | Estado: " + estado +
               " | Monto: " + monto;
    }
}
