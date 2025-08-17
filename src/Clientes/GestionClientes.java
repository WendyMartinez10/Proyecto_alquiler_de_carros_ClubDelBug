/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import Lists.List;
import Personas.Persona;
import java.util.ArrayList;
import java.util.HashSet;


/**
 *
 * @author USER
 */
public class GestionClientes implements List<Cliente> {
    private ArrayList<Cliente> clientes;

    public GestionClientes() {
        clientes = new ArrayList<>();
    }

    @Override
    public boolean add(Cliente t) {
         if (find(t.getCedula()) != null) return false;
        clientes.add(t);
        return true;

    }

    @Override
    public boolean remove(Cliente t) {
         if (tieneReservasActivas(t)) {
            throw new IllegalStateException("No se puede eliminar el cliente porque tiene reservas activas.");
        }

        return clientes.removeIf(c -> c.getCedula().equals(t.getCedula()));

    }

    @Override
    public Cliente find(Object id) {
        String cedula = String.valueOf(id);
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        for (Cliente c : clientes) {
            System.out.println(c + ", edad: " + c.getEdad());
        }
    }
     public boolean update(String cedula, String nuevoTelefono, String nuevoCorreo, String nuevaLicencia) {
        Cliente cliente = find(cedula);
        if (cliente == null) return false;

        if (!Persona.validarTelefono(nuevoTelefono)) return false;
        if (!Persona.validarCorreo(nuevoCorreo)) return false;
        if (nuevaLicencia == null || nuevaLicencia.isEmpty()) return false;

        cliente.setTelefono(nuevoTelefono);
        cliente.setCorreo(nuevoCorreo);
        cliente.setLicencia(nuevaLicencia);
        return true;
    }


    private boolean tieneReservasActivas(Cliente t) {
        // Simulación: reemplaza con tu lógica real
        return false;
    }

    public HashSet<String> getCedulasRegistradas() {
        HashSet<String> set = new HashSet<>();
        for (Cliente c : clientes) {
            set.add(c.getCedula());
        }
        return set;
    }
    public HashSet<String> getCorreosUnicos() {
        HashSet<String> set = new HashSet<>();
        for (Cliente c : clientes) {
            set.add(c.getCorreo());
        }
        return set;
    }

    public HashSet<String> getLicenciasUnicas() {
        HashSet<String> set = new HashSet<>();
        for (Cliente c : clientes) {
            set.add(c.getLicencia());
        }
        return set;
    }
}
