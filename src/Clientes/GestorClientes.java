/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;
import Reserva.Reserva;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author wen
 */
public class GestorClientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public GestorClientes() {
          clientes.add(new Cliente("10101010", "Juan Pérez",
                LocalDate.of(1990, 5, 20), "88887777", "juan@mail.com", "b1"));
    }
    
    
    

    public void agregarCliente(Cliente cliente) throws Exception {

        for (Cliente c : clientes) {
            if (c.getCedula().equals(cliente.getCedula())) {
                throw new Exception("Ya existe un cliente con esta cédula.");
            }
        }
        if (cliente.getEdad() < 18) {
            throw new Exception("El cliente debe ser mayor de 18 años.");
        }
        if (cliente.getLicenciaConducir() == null || cliente.getLicenciaConducir().isEmpty()) {
            throw new Exception("El cliente debe tener número de licencia.");
        }
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", cliente.getCorreo())) {
            throw new Exception("Correo inválido.");
        }
        if (!cliente.getTelefono().matches("\\d{8}")) {
            throw new Exception("Teléfono inválido, debe tener 8 dígitos.");
        }

        clientes.add(cliente);
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }
    
    

    public void actualizarCliente(String cedula, String nombre, LocalDate nacimiento,
            String telefono, String correo, String licencia) throws Exception {
        Cliente c = buscarCliente(cedula);
        if (c == null) {
            throw new Exception("Cliente no encontrado.");
        }

  
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("Nombre inválido.");
        }

        if (nacimiento == null || nacimiento.isAfter(LocalDate.now().minusYears(18))) {
            throw new Exception("El cliente debe ser mayor de 18 años.");
        }

        if (!telefono.matches("\\d{8}")) {
            throw new Exception("Teléfono inválido.");
        }

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", correo)) {
            throw new Exception("Correo inválido.");
        }

        if (licencia == null || licencia.isEmpty()) {
            throw new Exception("Debe ingresar una licencia válida.");
        }


        c.setNombre(nombre);
        c.setFechaNacimiento(nacimiento);
        c.setTelefono(telefono);
        c.setCorreo(correo);
        c.setLicenciaConducir(licencia);
    }

    public void eliminarCliente(String cedula, ArrayList<Reserva> reservas) throws Exception {
        Cliente c = buscarCliente(cedula);
        if (c == null) {
            throw new Exception("Cliente no encontrado.");
        }

        for (Reserva r : reservas) {
          
            if (r.isConfirmada() && r.getCliente().getCedula().equals(cedula)) {
                throw new Exception("No se puede eliminar cliente con reservas activas.");
            }
        }

        clientes.remove(c);
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }
}
