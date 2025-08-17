/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import Personas.Persona;
import java.time.LocalDate;


/**
 *
 * @author USER
 */
public abstract class Cliente extends Persona {
   
    private String licencia;

    public Cliente(String cedula, String nombre, LocalDate fechaNacimiento, String telefono, String correo, String licencia) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
         if (licencia == null || licencia.isEmpty()) {
            throw new IllegalArgumentException("No se puede registrar cliente sin número de licencia.");
        }

        this.licencia = licencia;
    }

    public String getLicencia() { 
        return licencia; 
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
  @Override
    public String toString() {
        return "Persona{" + "cedula:" + cedula + ", nombre:" + nombre + ", fechaNacimiento:" + fechaNacimiento + ", telefono:" + telefono + ", correo:" + correo +", licencia=" + licencia +  '}';
    }
    
}
