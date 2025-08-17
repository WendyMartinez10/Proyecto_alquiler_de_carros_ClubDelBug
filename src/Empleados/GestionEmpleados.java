/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class GestionEmpleados {

    private List<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminarPorCedula(String cedula) {
        Empleado e = buscarPorCedula(cedula);
        if (e != null) {
            empleados.remove(e);
            return true;
        }
        return false;
    }

    public List<Empleado> listarEmpleados() {
        return empleados;
    }
}
