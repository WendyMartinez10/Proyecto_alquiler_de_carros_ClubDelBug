/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author gipsy
 */
public enum Tipo_de_Vehiculo {
    SEDAN("Sedan"),
    SUV("SUV"),
    PICKUP("Pick-up");
    
    private final String description;

    private Tipo_de_Vehiculo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    
    public static boolean esValido(String tipo){
        try { 
            valueOf(tipo.toUpperCase());
        return true;
        } catch (IllegalArgumentException e){
        return false;
    }
}
}