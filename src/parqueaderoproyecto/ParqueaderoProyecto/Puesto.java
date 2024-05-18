/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

/**
 *
 * @author Juan Camilo Gomez
 */
public class Puesto {
    // Se crean las variables de las posiciones de los puestos
    private int i;
    private int j;
    private Vehiculo vehiculo;

    // Valor del puesto en posiciones i y j
    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Metodo Boolean para determinar si esta disponible el puesto
    public boolean estaDisponible() {
        return vehiculo == null;
    }

    // Metodo para que un vehiculo ocupe su puesto asignado
    public void ocuparPuesto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    // Metodo para desocupar un puesto ocupado por un vehiculo
    public void desocuparPuesto() {
        this.vehiculo = null;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Override para ocupar el puesto por el vehiculo
    @Override
    public String toString() {
        return "Puesto (" + i + ", " + j + ")";
    }

    // Descripcion de los puestos cuando el usuario quiere ver la gráfica en el caso 5 del switch case
    public String getDescripcion() {
        if (vehiculo == null) {
            return "Vacio";
        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            return "Moto (" + moto.getTipoMoto() + ", " + vehiculo.getPlaca() + ")";
        } else if (vehiculo instanceof Carro) {
            return "Carro (" + vehiculo.getPlaca() + ")";
        }
        return "Desconocido";
    }
}