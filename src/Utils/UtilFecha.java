/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * @author USER
 */
public class UtilFecha {
 
    public static int calcularEdad(LocalDate fecha) {
        return Period.between(fecha, LocalDate.now()).getYears();
    }

    public static boolean noEsFechaFutura(LocalDate fecha) {
        return fecha != null && !fecha.isAfter(LocalDate.now());
    }

    public static boolean esMayorDeEdad(LocalDate fecha) {
        return calcularEdad(fecha) >= 18;
    }

    public static LocalDate convertirFecha(String fechaTexto) {
        try {
            return LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static String fechaAString(LocalDate fecha) {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }



}
