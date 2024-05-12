/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyetoparqueadero;

/**
 *
 * @author UrbanAgent
 */
public class PuestoParqueadero {
    private int posicionI;
    private int posicionJ;
    private Vehiculo vehiculoOcupante;

    // Constructor
    public PuestoParqueadero(int posicionI, int posicionJ) {
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.vehiculoOcupante = null; // Inicialmente no hay vehículo ocupante
    }
    
    // Getters
    public int getPosicionI() {
        return posicionI;
    }

    public int getPosicionJ() {
        return posicionJ;
    }

    public Vehiculo getVehiculoOcupante() {
        return vehiculoOcupante;
    }
    
    // Setters
    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

    public void setPosicionJ(int posicionJ) {
        this.posicionJ = posicionJ;
    }

    public void setVehiculoOcupante(Vehiculo vehiculo) {
        this.vehiculoOcupante = vehiculo;
    }
}
