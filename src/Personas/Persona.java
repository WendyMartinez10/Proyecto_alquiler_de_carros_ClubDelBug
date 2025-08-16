/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;
import Utils.UtilFecha;
import java.time.LocalDate;


/**
 *
 * @author USER
 */
public abstract class Persona {
    protected String cedula;
    protected String nombre;
    protected LocalDate fechaNacimiento;
    protected String telefono;
    protected String correo;

    public Persona(String cedula, String nombre, LocalDate fechaNacimiento, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        if(validarTelefono(telefono))
        this.telefono = telefono;
        if(validarCorreo(correo))
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public int getEdad() {
       return UtilFecha.calcularEdad(fechaNacimiento);
    }
    public String getCedula() {
       return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
        
}
    public void setTelefono(String telefono) {
          if(validarTelefono(telefono))
       this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        if (validarCorreo(correo))
       this.correo = correo;
    }

    
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("^[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}$");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }


    @Override
    public String toString() {
        return "Persona{" + "cedula:" + cedula + ", nombre:" + nombre + ", fechaNacimiento:" + fechaNacimiento + ", telefono:" + telefono + ", correo:" + correo + '}';
    }

}