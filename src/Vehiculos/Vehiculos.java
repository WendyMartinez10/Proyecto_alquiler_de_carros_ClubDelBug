/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;
import Vehiculos.ExcepcionVehiculo;
import java.time.Year;

/**
 *
 * @author gipsy
 */
public class Vehiculos {
    private String Marca;
    private String Placa;
    private String modelo;
    private int Año;
    private Tipo_de_Vehiculo tipo;
    private Estado_Vehiculo estado;
    
    private void ValidarDatos(String Marca,String Placa,String modelo,int año,String tipo,String estado ) throws ExcepcionVehiculo{

     if (Placa == null || Placa.trim().isEmpty()) 
         throw new ExcepcionVehiculo("La placa es obligatoria.");
     if (Marca == null || Marca.trim().isEmpty()) {
         throw new ExcepcionVehiculo("La marca es obligatoria y no puede estar vacía");
     }
     if (modelo == null || modelo.trim().isEmpty()) {
         throw new ExcepcionVehiculo("El modelo es obligatorio y no puede estar vacío"); 
     }
     if (!AñoValido(año)){
         throw new ExcepcionVehiculo("Año inválido.");
     }
     if(!Tipo_de_Vehiculo.esValido(tipo)) {
         throw new ExcepcionVehiculo("Tipo de vehículo inválido.");
        }
     if(!Estado_Vehiculo.esValido(estado)) 
         throw new ExcepcionVehiculo("Estado de vehículo inválido.");
     
    }



    private boolean AñoValido(int Año){
        int Actual = Year.now().getValue();
        return Año <= Actual && Año >= Actual - 20;
    }

    public String getMarca() {
        return Marca;
    }

    public String getPlaca() {
        return Placa;
    }

    public String getModelo() {
        return modelo;
    }

   
    public int getAño() {
        return Año;
    }

    public Tipo_de_Vehiculo getTipo() {
        return tipo;
    }

    public Estado_Vehiculo getEstado() {
        return estado;
    }

    public void setMarca(String Marca) throws ExcepcionVehiculo {
      if (Marca == null || Marca.trim().isEmpty()) {
         throw new ExcepcionVehiculo("La marca es obligatoria y no puede estar vacía");
     }
        this.Marca = Marca;
    }

    public void setPlaca(String Placa) throws ExcepcionVehiculo {
        if (Placa == null || Placa.trim().isEmpty()) {
         throw new ExcepcionVehiculo("La placa es obligatoria.");
     }
        this.Placa = Placa;
    }

    public void setModelo(String modelo)  throws ExcepcionVehiculo {
        if (modelo == null || modelo.trim().isEmpty()){
         throw new  ExcepcionVehiculo("El modelo es obligatorio y no puede estar vacío."); 
     }
        this.modelo = modelo;
    }

    public void setAño(int Año)  throws ExcepcionVehiculo {
        if(!AñoValido(Año))
            throw new ExcepcionVehiculo("Año inválido.");
        this.Año = Año;
    }
    

    public void setTipo(String tipo) throws ExcepcionVehiculo {
        if (!Tipo_de_Vehiculo.esValido(tipo)) 
             throw new ExcepcionVehiculo("Tipo inválido.");
        this.tipo = Tipo_de_Vehiculo.valueOf(tipo.toUpperCase());
    }

    public void setEstado(String estado)  throws ExcepcionVehiculo {
        if(!Estado_Vehiculo.esValido(estado))
             throw new ExcepcionVehiculo("Estado inválido.");
        this.estado = Estado_Vehiculo.valueOf(estado.toUpperCase());
    }

    public Vehiculos(String Marca, String Placa, String modelo, int Año, String tipo, String estado) throws ExcepcionVehiculo {
        ValidarDatos(Marca,Placa,modelo,Año,tipo,estado);
        this.Marca = Marca;
        this.Placa = Placa;
        this.modelo = modelo;
        this.Año = Año;
        this.tipo = Tipo_de_Vehiculo.valueOf(tipo.toUpperCase());
        this.estado = Estado_Vehiculo.valueOf(estado.toUpperCase());
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "Marca=" + Marca + ", Placa=" + Placa + ", modelo=" + modelo + ", A\u00f1o=" + Año + ", tipo=" + tipo + ", estado=" + estado + '}';
    }

   }

