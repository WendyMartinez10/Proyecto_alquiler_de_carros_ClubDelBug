/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrato;

import Clientes.Cliente;
import Lists.List;
import Vehiculos.Vehiculos;
import java.util.ArrayList;

/**
 *
 * @author josep
 */
public class GestionContratos implements List<Contratos>{
    private ArrayList<Contratos> contratos;

    public GestionContratos() {
        contratos = contratos;
    }
    
    @Override
    public boolean add(Contratos c) {
        if (find(c.getIdContrato())!=null) return false;
        contratos.add(c);
        return true;
    }

    @Override
    public boolean remove(Contratos c) {
        return contratos.remove(c);
    }

    @Override
    public Contratos find(Object id) {
        String idContratos = String.valueOf(id);
        for (Contratos c : contratos){
            if (c.getIdContrato().equals(idContratos)){
                return c;
            }
        }
         return null;
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<String> getAllString(){
        ArrayList<String> lista = new ArrayList<>();
        for (Contratos c : contratos){
            lista.add(c.toString());
        }
        return lista;
    }
    
    public ArrayList<Contratos> getContratosCliente(Cliente cliente){
        ArrayList<Contratos> result = new ArrayList<>();
        for (Contratos c : contratos) {
            if (c.getCliente().getCedula().equals(cliente.getCedula())){
                result.add(c);
            }
        }
        return result;
    }
    
    public ArrayList<Contratos> getContratosVehiculo(Vehiculos vehiculo){
        ArrayList<Contratos> result = new ArrayList<>();
        for (Contratos c : contratos) {
            if (c.getVehiculos().getPlaca().equals(vehiculo.getPlaca())){
                result.add(c);
            }
        }
        return result;
    }
}
