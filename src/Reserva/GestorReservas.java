/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Clases.Reserva;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author AsusVivobook
 */
public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void crearReserva(Reserva r) throws Exception {
      
        if (r.getFechaInicio().isBefore(LocalDate.now()))
            throw new Exception("La fecha de inicio no puede ser menor a la actual.");
        if (r.getFechaFin().isBefore(r.getFechaInicio()))
            throw new Exception("La fecha de fin debe ser posterior a la de inicio.");
        if (r.getFechaInicio().plusDays(30).isBefore(r.getFechaFin()))
            throw new Exception("La reserva no puede durar más de 30 días.");


        for (Reserva x : reservas) {
            if (x.getVehiculo().getPlaca().equals(r.getVehiculo().getPlaca())
                    && x.isConfirmada()
                    && !(r.getFechaFin().isBefore(x.getFechaInicio()) || r.getFechaInicio().isAfter(x.getFechaFin()))) {
                throw new Exception("El vehículo ya tiene una reserva en esas fechas.");
            }
        }
        reservas.add(r);
    }

public ArrayList<Reserva> buscarReservas(String cedula, LocalDate inicio, LocalDate fin) {
    ArrayList<Reserva> resultados = new ArrayList<>();

    for (Reserva r : reservas) {
        boolean coincide = true;

        if (cedula != null && !cedula.isEmpty() && !r.getCliente().getCedula().equals(cedula)) {
            coincide = false;
        }
        if (inicio != null && r.getFechaInicio().isBefore(inicio)) {
            coincide = false;
        }
        if (fin != null && r.getFechaFin().isAfter(fin)) {
            coincide = false;
        }

        if (coincide) resultados.add(r);
    }
    return resultados;
}

    public void cancelarReserva(Reserva r) throws Exception {
        if (r.getFechaInicio().isAfter(LocalDate.now())) {
            reservas.remove(r);
        } else {
            throw new Exception("No se puede cancelar una reserva ya iniciada.");
        }
    }

    public ArrayList<Reserva> listarReservas() { return reservas; }
}
