/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import Personas.Persona;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.Period;

/**
 *
 * @author AsusVivobook
 */

public class Empleado extends Persona {
    
    private String puesto;
    private double salario;
    private LocalDate fechaIngreso;

    public Empleado(String cedula, String nombre, LocalDate fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = (salario >= 0) ? salario : 0;
    }

    public void setFechaIngreso(String fechaIngresoStr) {
        try {
            this.fechaIngreso = LocalDate.parse(fechaIngresoStr);
        } catch (DateTimeParseException e) {
            this.fechaIngreso = null; 
        }
    }

    public int calcularAntiguedad() {
        if (fechaIngreso == null) {
            return 0;
        }
        return Period.between(fechaIngreso, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Empleado{" + "puesto=" + puesto + ", salario=" + salario + ", fechaIngreso=" + fechaIngreso + '}';
    }
}
