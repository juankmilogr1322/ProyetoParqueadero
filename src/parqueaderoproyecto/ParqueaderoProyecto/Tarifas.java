/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

/**
 *
 * @author Juan Camilo Gomez
 */
public class Tarifas {
    // se crean la variables de todos los tipos de vehiculos
    private double tarifaMotoClasica;
    private double tarifaMotoHibrida;
    private double tarifaCarro;

    public Tarifas(double tarifaMotoClasica, double tarifaMotoHibrida, double tarifaCarro) {
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMotoHibrida;
        this.tarifaCarro = tarifaCarro;
    }

    // Getters
    public double getTarifaMotoClasica() {
        return tarifaMotoClasica;
    }

    public double getTarifaMotoHibrida() {
        return tarifaMotoHibrida;
    }

    public double getTarifaCarro() {
        return tarifaCarro;
    }
}