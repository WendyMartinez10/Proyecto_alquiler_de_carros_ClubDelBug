/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author gipsy
 */
public enum Estado_Vehiculo {
    DISPONIBLE("Disponible"),
    ALQUILADO("Alquilado"),
    MANTENIMIENTO("En mantenimiento");
    
    private final String description;

    private Estado_Vehiculo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public static boolean esValido(String estado){
        try {
            valueOf(estado.toUpperCase());
            return true;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }
}

  