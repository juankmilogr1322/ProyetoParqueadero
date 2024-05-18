/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

/**
 *
 * @author Juan Camilo Gomez
 */
class Carro extends Vehiculo {
    public Carro(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario); // Atributos heredados del padre
    }

    // Se calcula la tarifa del carro
    @Override
    public double calcularTarifa(long horasEstacionado, Tarifas tarifas) {
        return tarifas.getTarifaCarro() * horasEstacionado;
    }
}