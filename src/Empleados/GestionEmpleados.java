/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import Lists.List;
import java.util.ArrayList;


/**
 *
 * @author AsusVivobook
 */
public class GestionEmpleados implements List<Empleado> {

    private ArrayList<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    @Override
    public boolean add(Empleado e) {
        if (find(e.getCedula()) != null) {
            return false; 
        }
        empleados.add(e);
        return true;
    }

    @Override
    public boolean remove(Empleado e) {
        return empleados.removeIf(emp -> emp.getCedula().equals(e.getCedula()));
    }

    @Override
    public Empleado find(Object id) {
        String cedula = String.valueOf(id);
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        //Por si la interfaz necesita la lista 
    }

    public boolean update(String cedula, String nuevoTelefono, String nuevoCorreo, String nuevoPuesto) {
        Empleado e = find(cedula);
        if (e != null) {
            e.setTelefono(nuevoTelefono);
            e.setCorreo(nuevoCorreo);
            e.setPuesto(nuevoPuesto);
            return true;
        }
        return false;
    }

    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(empleados); 
    }
}
