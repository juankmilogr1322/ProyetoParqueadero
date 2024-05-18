/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

import java.util.Date;

/**
 *
 * @author Juan Camilo Gomez
 */

// Clase para almacenar horas de ingreso y toda la información en cuanto a esto
public class Ingreso {
    private Vehiculo vehiculo;
    private Date tiempoSalida;
    private double monto; // Se declara el monto a cobrar 

    public Ingreso(Vehiculo vehiculo, Date tiempoSalida, double monto) {
        this.vehiculo = vehiculo;
        this.tiempoSalida = tiempoSalida;
        this.monto = monto;
    }

    // Getters 
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getTiempoSalida() {
        return tiempoSalida;
    }

    public double getMonto() {
        return monto;
    }

    public String getTipoVehiculo() {
        
        /*
        *   Con el instaceof verificamos i el objeto vehiculo es una instancia de la clase Moto. Si sí, se ejecuta el if
        *   En el if, si vehu¿iculo es ina instancia de Moto, se le realiza casting para convertirlo explicitamente en un objeto de tipo Moto
        */
        if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            return moto.getTipoMoto().name();
        } else if (vehiculo instanceof Carro) { // se verifica si es una instancia de la clase Carro
            return "CARRO";
        }
        return "DESCONOCIDO"; // Si vehiculo no es ni una instancia de Moto ni de Carro, se devuelve la cadena “DESCONOCIDO”.
    }
}
