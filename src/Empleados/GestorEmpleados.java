/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Clases.Empleado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author AsusVivobook
 */
public class GestorEmpleados {
     private ArrayList<Empleado> empleados = new ArrayList<>();

    public GestorEmpleados() {
          Empleado e1 = new Empleado(
                "123456789",               // cédula
                "Juan Pérez",              // nombre
                LocalDate.of(1990, 5, 15),// fecha de nacimiento
                "88881234",               // teléfono
                "juan.perez@mail.com",    // correo
                "Vendedor",               // puesto
                500.0                     // salario
            );

          
            empleados.add(e1);
    }
     
     
     

    public void agregarEmpleado(Empleado e) throws Exception {
        for (Empleado x : empleados) {
            if (x.getCedula().equals(e.getCedula())) {
                throw new Exception("Ya existe un empleado con esa cédula.");
            }
        }
        if (e.getEdad() < 18) throw new Exception("El empleado debe ser mayor de 18 años.");
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", e.getCorreo()))
            throw new Exception("Correo inválido.");
        if (!e.getTelefono().matches("\\d{8}"))
            throw new Exception("Teléfono inválido, debe tener 8 dígitos.");

        empleados.add(e);
    }

    public Empleado buscarEmpleado(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) return e;
        }
        return null;
    }

    public void actualizarEmpleado(String cedula, String telefono, String correo, String puesto) throws Exception {
        Empleado e = buscarEmpleado(cedula);
        if (e == null) throw new Exception("Empleado no encontrado.");
        if (!telefono.matches("\\d{8}")) throw new Exception("Teléfono inválido.");
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", correo))
            throw new Exception("Correo inválido.");
        e.setTelefono(telefono);
        e.setCorreo(correo);
        e.setPuesto(puesto);
    }

    public void eliminarEmpleado(String cedula) throws Exception {
        Empleado e = buscarEmpleado(cedula);
        if (e == null) throw new Exception("Empleado no encontrado.");
        empleados.remove(e);
    }
    
      public Empleado obtenerEmpleadoAleatorio() throws Exception {
        if (empleados.isEmpty()) {
            throw new Exception("No hay empleados registrados.");
        }
        Random rand = new Random();
        return empleados.get(rand.nextInt(empleados.size()));
    }

    public ArrayList<Empleado> listarEmpleados() { return empleados; }
}
