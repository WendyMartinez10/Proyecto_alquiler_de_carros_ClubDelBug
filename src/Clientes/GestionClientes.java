/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class GestionClientes {
     private ArrayList<Cliente> clientes = new ArrayList<>();

    public boolean validarCliente(Cliente cliente) {
        return esCedulaUnica(cliente.getCedula()) &&
               cliente.getEdad() >= 18 &&
               esTelefonoValido(cliente.getTelefono()) &&
               esCorreoValido(cliente.getCorreo()) &&
               !cliente.getLicencia().isEmpty();
    }

    public boolean esCedulaUnica(String cedula) {
        return buscarCliente(cedula) == null;
    }

    public boolean esTelefonoValido(String telefono) {
        return telefono.matches("^\\d{8}$");
    }

    public boolean esCorreoValido(String correo) {
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) return c;
        }
        return null;
    }

    public boolean eliminarCliente(String cedula, boolean tieneReservaActiva) {
        Cliente c = buscarCliente(cedula);
        if (c != null && !tieneReservaActiva) {
            clientes.remove(c);
            return true;
        }
        return false;
    }

    public boolean actualizarCliente(String cedula, String nuevoTelefono, String nuevoCorreo, String nuevaLicencia) {
        Cliente c = buscarCliente(cedula);
        if (c != null &&
            esTelefonoValido(nuevoTelefono) &&
            esCorreoValido(nuevoCorreo) &&
            !nuevaLicencia.isEmpty()) {
            
            c.setTelefono(nuevoTelefono);
            c.setCorreo(nuevoCorreo);
            c.setLicencia(nuevaLicencia);
            return true;
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
