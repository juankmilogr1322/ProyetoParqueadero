/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyetoparqueadero;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UrbanAgent
 */
public class RegistroParqueadero {
    private int puestosDisponibles;
    private final List<Vehiculo> listaVehiculosParqueados;

    // Constructor
    public RegistroParqueadero(int puestosDisponibles) {
        this.puestosDisponibles = puestosDisponibles;
        this.listaVehiculosParqueados = new ArrayList<>();
    }

    // Método para registrar el ingreso de un vehículo
    public void registrarIngreso(Vehiculo vehiculo, PuestoParqueadero puesto) {
        if (puestosDisponibles > 0) {
            listaVehiculosParqueados.add(vehiculo);
            puesto.setVehiculoOcupante(vehiculo);
            puestosDisponibles--;
            System.out.println("Ingreso registrado para vehículo con placa " + vehiculo.getPlaca());
        } else {
            System.out.println("No hay puestos disponibles en el parqueadero.");
        }
    }

    // Método para registrar la salida de un vehículo
    public void registrarSalida(PuestoParqueadero puesto) {
        if (puesto.getVehiculoOcupante() != null) {
            listaVehiculosParqueados.remove(puesto.getVehiculoOcupante());
            puesto.setVehiculoOcupante(null);
            puestosDisponibles++;
            System.out.println("Salida registrada para vehículo con placa " + puesto.getVehiculoOcupante().getPlaca());
        } else {
            System.out.println("El puesto está vacío. No se puede registrar la salida.");
        }
    }

    // Método para buscar el propietario de un vehículo en un puesto
    public String buscarPropietario(PuestoParqueadero puesto) {
        if (puesto.getVehiculoOcupante() != null) {
            return puesto.getVehiculoOcupante().getPropietario();
        } else {
            return "El puesto está vacío.";
        }
    }
}
