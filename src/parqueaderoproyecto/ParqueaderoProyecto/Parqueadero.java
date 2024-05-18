/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juan Camilo Gomez
 */
public class Parqueadero {
    // Se asignan las listas necesarias para la complementacion correcta del parqueadero
    private List<List<Puesto>> puestos;
    private List<String> historicoIngresos;
    private List<Ingreso> ingresos;
    private Tarifas tarifas;

    public Parqueadero(int filas, int columnas, Tarifas tarifas) {
        this.puestos = new ArrayList<>();
        this.historicoIngresos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
        this.tarifas = tarifas;

        // Creacion de la lista de puestos tomando en cuenta posiciones i y j ingresados por el usuario
        for (int i = 0; i < filas; i++) {
            List<Puesto> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(new Puesto(i, j));
            }
            puestos.add(fila);
        }
    }

    // Creacion del metodo ingresarVehiculo para nuevos vehiculos
    public boolean ingresarVehiculo(Vehiculo vehiculo, int i, int j) {
        if (i >= puestos.size() || j >= puestos.get(i).size()) {
            System.out.println("Puesto fuera de rango.");
            return false;
        }

        // Verificacion del estado del puesto y asignacion del vehiculo al registro de ingresos
        Puesto puesto = puestos.get(i).get(j);
        if (puesto.estaDisponible()) {
            puesto.ocuparPuesto(vehiculo);
            historicoIngresos.add("Vehiculo " + vehiculo + " ingresó a " + puesto + " a las " + vehiculo.getTiempoEntrada());
            return true;
        } else {
            System.out.println("Puesto (" + i + ", " + j + ") no está disponible.");
            return false;
        }
    }

    // Creacion del metodo retirarVehiculo para vehiculos que vayan a salir
    public void retirarVehiculo(int i, int j) {
        if (i >= puestos.size() || j >= puestos.get(i).size()) {
            System.out.println("Puesto fuera de rango.");
            return;
        }

        // Verifiación del vehiculo que esta ocupando el puesto. Calculo de su tarifa por el tiempo estacionado.
        Puesto puesto = puestos.get(i).get(j);
        if (!puesto.estaDisponible()) {
            Vehiculo vehiculo = puesto.getVehiculo();
            long tiempoEstacionado = (new Date().getTime() - vehiculo.getTiempoEntrada().getTime()) / (1000 * 60 * 60);
            double costo = vehiculo.calcularTarifa(tiempoEstacionado, tarifas);
            puesto.desocuparPuesto();
            ingresos.add(new Ingreso(vehiculo, new Date(), costo));
            System.out.println("Vehiculo " + vehiculo + " ha sido retirado del puesto " + puesto);
            System.out.println("Tiempo estacionado: " + tiempoEstacionado + " horas. Costo: $" + costo);
        // Si el puesto no esta ocupado se imprime el else
        } else {
            System.out.println("No hay vehículo en el puesto (" + i + ", " + j + ").");
        }
    }

    // Metodo buscar vehiculo por el puesto que se ingrese
    public Vehiculo buscarVehiculoPorPuesto(int i, int j) {
        if (i >= puestos.size() || j >= puestos.get(i).size()) {
            System.out.println("Puesto fuera de rango.");
            return null;
        }
        // Impresion del vehiculo en el puesto dado
        return puestos.get(i).get(j).getVehiculo();
    }

    // Metodo para imprimir Hsitorico de ingresos en el parqueadero, llama a la calse ´Ingreso´
    public void imprimirHistoricoIngresos() {
        for (String ingreso : historicoIngresos) {
            System.out.println(ingreso);
        }
    }

    
    public void graficarParqueadero() {
        for (int i = 0; i < puestos.size(); i++) {
            for (int j = 0; j < puestos.get(i).size(); j++) {
                Puesto puesto = puestos.get(i).get(j);
                /*
                *   Aquí se usa el método String.format para formatear una cadena de texto, es decir, arrancar de nuevo y hacer una de seguido
                *   El formato´%-30s´ nos permite alojar una cadena que tenga una longitud total del 30 caracteres.
                *   Con el signo menos indicamos que queremos alineación a la izquierda 
                */
                System.out.print(String.format("%-30s", puesto.getDescripcion()) + " ");
            }
            System.out.println();
        }
    }
   
    // Generación del reporte diario con la fecha específica ingresada
    public void generarReporteDiario(Date dia) {
        
       /*
        *   esta línea de código crea un objeto SimpleDateFormat con el patrón "yyyy-MM-dd" y luego formatea la fecha contenida en el objeto 
        *   dia. Si dia representa una fecha, diaStr contendrá la representación formateada de esa fecha en el formato “año-mes-día”.
        */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String diaStr = sdf.format(dia);
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;
        double totalCarro = 0;

        // Se crea el bucle con un switch case en el que el reporte generará sus resultados validando datos de ingresos del dia seleccionado
        for (Ingreso ingreso : ingresos) {
            if (sdf.format(ingreso.getTiempoSalida()).equals(diaStr)) {
                switch (ingreso.getTipoVehiculo()) {
                    case "CLASICA":
                        totalMotoClasica += ingreso.getMonto();
                        break;
                    case "HIBRIDA":
                        totalMotoHibrida += ingreso.getMonto();
                        break;
                    case "CARRO":
                        totalCarro += ingreso.getMonto();
                        break;
                }
            }
        }

        // Print del reporte diario:
        System.out.println("Reporte diario del " + diaStr + ":");
        System.out.println("Total recaudado por Motos Clásicas: $" + totalMotoClasica);
        System.out.println("Total recaudado por Motos Híbridas: $" + totalMotoHibrida);
        System.out.println("Total recaudado por Carros: $" + totalCarro);
        System.out.println("Total general: $" + (totalMotoClasica + totalMotoHibrida + totalCarro));
    }
    
    // Se crea el bucle con un switch case en el que el reporte generará sus resultados validando datos de ingresos del mes seleccionado
    public void generarReporteMensual(int mes, int anio) {
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;
        double totalCarro = 0;
        Calendar cal = Calendar.getInstance(); // Se crea una clase Calendar llamada ´cal´. 
                                               // El método getInstance se utiliza para obtener una instancia de un 
                                               // calendario según la zona horaria actual.

        for (Ingreso ingreso : ingresos) {
            cal.setTime(ingreso.getTiempoSalida());
            int mesIngreso = cal.get(Calendar.MONTH) + 1; // Los meses en Calendar son de 0 a 11
            int anioIngreso = cal.get(Calendar.YEAR);

            // Se validan el mes y el año ingresados para poder mostrar el reporte
            if (mesIngreso == mes && anioIngreso == anio) {
                switch (ingreso.getTipoVehiculo()) {
                    case "CLASICA":
                        totalMotoClasica += ingreso.getMonto();
                        break;
                    case "HIBRIDA":
                        totalMotoHibrida += ingreso.getMonto();
                        break;
                    case "CARRO":
                        totalCarro += ingreso.getMonto();
                        break;
                }
            }
        }

        // Print del reporte mensual:
        System.out.println("Reporte mensual de " + mes + "/" + anio + ":");
        System.out.println("Total recaudado por Motos Clásicas: $" + totalMotoClasica);
        System.out.println("Total recaudado por Motos Híbridas: $" + totalMotoHibrida);
        System.out.println("Total recaudado por Carros: $" + totalCarro);
        System.out.println("Total general: $" + (totalMotoClasica + totalMotoHibrida + totalCarro));
    }
}
