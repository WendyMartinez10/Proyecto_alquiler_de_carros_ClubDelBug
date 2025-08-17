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
    public boolean add(Vehiculos t) throws ExcepcionVehiculo{
        if (map.containsKey(t.getPlaca())) {
            throw new ExcepcionVehiculo("Ya existe un vehiculo con esa placa");
        }
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
    public Vehiculos find(Object Id)  throws ExcepcionVehiculo {
        if(!(Id instanceof String)) {
             throw new ExcepcionVehiculo("Debes Ingresar una placa valida");
        }
        String Placa = (String) Id;
        Vehiculos v = map.get(Placa);
        if (v == null){
            throw new ExcepcionVehiculo("No se encontro ningun vehiculo con la placa: "+ Placa);
        }
            return v; 
    
    }
    

    @Override
    public void showAll() {
       for(Vehiculos v : map.values()){
           System.out.println(v);
    }

    }
}
    


   

  


   
