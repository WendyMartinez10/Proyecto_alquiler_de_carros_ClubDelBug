/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gipsy
 */
public class GestorVehiculos implements ListGestionVehiculos<Vehiculos> {
    private HashMap<String, Vehiculos> map = new HashMap<>();

    public GestorVehiculos() {
        this.map = new HashMap<>();
    }
    @Override 
    public boolean add(Vehiculos t){
        if (map.containsKey(t.getPlaca())) return false;
        map.put(t.getPlaca(), t);
        return true;
    }

    @Override 
    public boolean remove(Vehiculos t) throws ExcepcionVehiculo {
        if(!map.containsKey(t.getPlaca())){
            return false;
}
        if(t.getEstado() == Estado_Vehiculo.ALQUILADO){
            throw new ExcepcionVehiculo("No se puede eliminar un vehiculo Alquilado");
        }
        map.remove(t.getPlaca());
        return true;
        
    }
    @Override
    public Vehiculos find(Object Id) {
        String Placa = String.valueOf(Id);
        return map.get(Placa);
    
    }
    

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(Object Id, Vehiculos NuevoObjecto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}

   
