/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author gipsy
 */
public interface ListGestionVehiculos <T> {
    boolean add(T t);
    boolean remove(T t) throws ExcepcionVehiculo;
    T find(Object Id);
    boolean Update(Object Id,T NuevoObjecto);
    void showAll();
}
