/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContractoVehiculo;

import ContractoVehiculo.ContratoVehiculo;
import java.util.ArrayList;

/**
 *
 * @author wen
 */
public class GestorContratos {
    private ArrayList<ContratoVehiculo> contratos = new ArrayList<>();

    public void crearContrato(ContratoVehiculo c) throws Exception {
        for (ContratoVehiculo x : contratos) {
            if (x.getVehiculo().getPlaca().equals(c.getVehiculo().getPlaca()) && x.getEstado().equals("Activo")) {
                throw new Exception("El vehículo ya tiene un contrato activo.");
            }
        }
        contratos.add(c);
    }

    public ContratoVehiculo buscarContrato(int numero) {
        for (ContratoVehiculo c : contratos) {
            if (c.getNumeroContrato() == numero) return c;
        }
        return null;
    }

    public void finalizarContrato(int numero) throws Exception {
        ContratoVehiculo c = buscarContrato(numero);
        if (c == null) throw new Exception("Contrato no encontrado.");
        if (!c.getEstado().equals("Activo")) throw new Exception("Solo contratos activos pueden finalizarse.");
        c.finalizar();
    }

    public void cancelarContrato(int numero) throws Exception {
        ContratoVehiculo c = buscarContrato(numero);
        if (c == null) throw new Exception("Contrato no encontrado.");
        if (c.getEstado().equals("Finalizado")) throw new Exception("No se puede cancelar un contrato finalizado.");
        c.cancelar();
    }

    public ArrayList<ContratoVehiculo> listarContratos() { return contratos; }
}