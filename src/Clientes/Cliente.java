/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.time.LocalDate;
/**
 *
 * @author wen
 */
public class Cliente extends Persona {
    private String licenciaConducir;

    public Cliente(String cedula, String nombre, LocalDate fechaNacimiento,
                   String telefono, String correo, String licenciaConducir) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.licenciaConducir = licenciaConducir;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }
    
    

    public String getLicenciaConducir() { return licenciaConducir; }

    @Override
    public String mostrarInfo() {
        return "Cliente: " + nombre + " | Cédula: " + cedula +
               " | Edad: " + getEdad() + " | Licencia: " + licenciaConducir;
    }
}