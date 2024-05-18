/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

/**
 *
 * @author Juan Camilo Gomez
 */
public class Moto extends Vehiculo {
    private int velocidadMaxima; // Se asigna la variable valocidadMaxima para las motos en especial
    private TipoMoto tipoMoto; // requerimos el tipo de moto presenrados en los enum por requerimiento del programa

    public Moto(String placa, String modelo, String propietario, int velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario); // Atributos heredados del padre
        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;
    }

    // Getters
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    // Override para la clase Motos con sus atributos
    @Override
    public String toString() {
        return super.toString() + ", Velocidad Máxima: " + velocidadMaxima + " km/h, Tipo: " + tipoMoto;
    }
    
    // Se genera el valor de la trarifa para las motos tanto hibridas como clasicas
    @Override
    public double calcularTarifa(long horasEstacionado, Tarifas tarifas) {
        double tarifaPorHora = (tipoMoto == TipoMoto.CLASICA) ? tarifas.getTarifaMotoClasica() : tarifas.getTarifaMotoHibrida();
        return tarifaPorHora * horasEstacionado;
    }
}