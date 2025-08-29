/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

import ContractoVehiculo.ContratoVehiculo;
import Clases.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author wen
 */
public class GestorVehiculos {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public GestorVehiculos() {
           vehiculos.add(new Vehiculo("ABC123", "Toyota", "Corolla", 2020, "Automóvil", "Disponible"));
    }
    
    
    

    public void agregarVehiculo(Vehiculo v) throws Exception {
        for (Vehiculo x : vehiculos) {
            if (x.getPlaca().equals(v.getPlaca())) {
                throw new Exception("Ya existe un vehículo con esa placa.");
            }
        }
        if (v.getAnio() > java.time.LocalDate.now().getYear()) {
            throw new Exception("El año no puede ser mayor al actual.");
        }
        if (java.time.LocalDate.now().getYear() - v.getAnio() > 20) {
            throw new Exception("El vehículo no puede tener más de 20 años.");
        }
     
        if (!(v.getEstado().equals("Disponible") || v.getEstado().equals("En alquiler") || v.getEstado().equals("En mantenimiento"))) {
            throw new Exception("Estado inválido.");
        }

        vehiculos.add(v);
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public void actualizarVehiculo(String placa, String marca, String modelo, int anio, String tipo, String estado) throws Exception {
        Vehiculo v = buscarVehiculo(placa);
        if (v == null) {
            throw new Exception("Vehículo no encontrado.");
        }

        if (anio > java.time.Year.now().getValue()) {
            throw new Exception("Año inválido.");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new Exception("La marca no puede estar vacía.");
        }

        v.setMarca(marca);
        v.setModelo(modelo);
        v.setAnio(anio);
        v.setTipo(tipo);
        v.setEstado(estado);
    }

    public void eliminarVehiculo(String placa, ArrayList<ContratoVehiculo> contratos) throws Exception {
        Vehiculo v = buscarVehiculo(placa);
        if (v == null) {
            throw new Exception("Vehículo no encontrado.");
        }
        for (ContratoVehiculo c : contratos) {
            if (c.getVehiculo().getPlaca().equals(placa) && c.getEstado().equals("Activo")) {
                throw new Exception("No se puede eliminar un vehículo alquilado.");
            }
        }
        vehiculos.remove(v);
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return vehiculos;
    }
}
