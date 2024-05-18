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
abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected String propietario; // Se toman los datos básicos necesarios requeridos por el programa
    protected Date tiempoEntrada; // crea un atributo de hora de entrada para llevar los costos de los vehiculos

    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.tiempoEntrada = new Date();
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public Date getTiempoEntrada() {
        return tiempoEntrada;
    }

    // El override de la clase
    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Propietario: " + propietario;
    }
    
    // Asignamos los parametros que recibe el método calcularTarifas
    public abstract double calcularTarifa(long horasEstacionado, Tarifas tarifas);
}
