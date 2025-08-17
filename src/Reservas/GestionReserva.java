/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;

import Clientes.Cliente;
import Lists.List;
import Vehiculos.Vehiculos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author josep
 */
public class GestionReserva implements List<Reserva> {
    private Queue<Reserva> reserva;

    public GestionReserva() {
       reserva = new LinkedList<>();
    }

    @Override
    public boolean add(Reserva r) {
        if (find(r.getIdReserva()) != null) return false;
        return reserva.offer(r);
    }

    @Override
    public boolean remove(Reserva r) {
        return reserva.remove(r);
    }

    @Override
    public Reserva find(Object id) {
        String idReserva = String.valueOf(id);
        for (Reserva r : reserva){
            if (r.getIdReserva().equals(idReserva)){
                return r;
            }
        }
        return null;
    }

   public ArrayList<String> getAllString() {
        ArrayList<String> lista = new ArrayList<>();
        for (Reserva r : reserva) {
            lista.add(r.toString());
        }
        return lista;
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Reserva atendReservas(){
        return reserva.poll();
    }
    
    public ArrayList<Reserva> getReservasClientes(Cliente cliente){
        ArrayList<Reserva> result=new ArrayList<>();
        for (Reserva r : reserva){
            if (r.getClientes().getCedula().equals(cliente.getCedula())){
                result.add(r);
            }
        }
        return result;
    }
    
    public ArrayList<Reserva> getReservasVehiculos(Vehiculos vehiculo){
        ArrayList<Reserva> result=new ArrayList<>();
        for (Reserva r : reserva){
            if (r.getVehiculos().getPlaca().equals(vehiculo.getPlaca())){
                result.add(r);
            }
        }
        return result;
    }
    
}
