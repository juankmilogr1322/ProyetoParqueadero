/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parqueaderoproyecto.ParqueaderoProyecto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Juan Camilo Gomez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cantidad de filas del parqueadero
        System.out.print("Ingrese el número de filas del parqueadero: ");
        int filas = scanner.nextInt();

        // Cantidad de columnas del parqueadero
        System.out.print("Ingrese el número de columnas del parqueadero: ");
        int columnas = scanner.nextInt();

        // Tarifa para motos CLASICAS x hora
        System.out.print("Ingrese la tarifa por hora para motos clásicas: ");
        double tarifaMotoClasica = scanner.nextDouble();

        // Tarifa para motos HIBRIDAS x hora
        System.out.print("Ingrese la tarifa por hora para motos híbridas: ");
        double tarifaMotoHibrida = scanner.nextDouble();

        // Tarifa para carros x hora
        System.out.print("Ingrese la tarifa por hora para carros: ");
        double tarifaCarro = scanner.nextDouble();

        // Creamos una nueva tarifa para aplicar a los respectivos metodos
        Tarifas tarifas = new Tarifas(tarifaMotoClasica, tarifaMotoHibrida, tarifaCarro);
        
        //Creamos un parqueadero que va a contener las filas ingresadas anteriormente, al igual que las columnas y las tarifas de los vehiculos x horas
        Parqueadero parqueadero = new Parqueadero(filas, columnas, tarifas);

        //Arrancamos con el menúy todas las opciones del software
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Buscar vehículo por puesto");
            System.out.println("4. Ver histórico de ingresos");
            System.out.println("5. Graficar parqueadero");
            System.out.println("6. Generar reporte diario");
            System.out.println("7. Generar reporte mensual");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Lector del número entero ingresado por el usuario independiente a la opción que escogió

            // Con un switch cases determinamos cada una de las posibles opciones que elija el usuario
            switch (opcion) {
                // In greso de vehiculo. Se piden sus respectivos datos requeridos por el programa
                case 1:
                    System.out.print("Ingrese el tipo de vehículo (moto/carro): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese la placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el propietario: ");
                    String propietario = scanner.nextLine();
                    Vehiculo vehiculo = null;

                    // Condicional si la respuesta fue "moto", entonces aplicar todos sus atributo (velocidad Maxima)
                    if (tipo.equalsIgnoreCase("moto")) {
                        System.out.print("Ingrese la velocidad máxima: ");
                        int velocidadMaxima = scanner.nextInt();
                        scanner.nextLine();
                        // Pedir tipo de moto CLASICA / HIBRIDA
                        System.out.print("Ingrese el tipo de moto (clasica/hibrida): ");
                        String tipoMotoStr = scanner.nextLine();
                        TipoMoto tipoMoto;
                        if (tipoMotoStr.equalsIgnoreCase("clasica")) {
                            // Aplicacion del enum en ambas opciones
                            tipoMoto = TipoMoto.CLASICA;
                        } else if (tipoMotoStr.equalsIgnoreCase("hibrida")) {
                            tipoMoto = TipoMoto.HIBRIDA;
                        } else {
                            // Respuesta a opciones no validas (Fuera de las opciones de respuesta)
                            System.out.println("Tipo de moto no válido.");
                            break;
                        }
                        // Creacion de la moto con los atributos ingresados anteriormente
                        vehiculo = new Moto(placa, modelo, propietario, velocidadMaxima, tipoMoto);
                    // Si no, y si es "carro" creacion de un nuevo carro con sus respectivos atributos
                    } else if (tipo.equalsIgnoreCase("carro")) {
                        vehiculo = new Carro(placa, modelo, propietario);
                    } else {
                        // Si ninguna de las opciones anteriores es valida (No se ingreso un vehiculo valido)
                        System.out.println("Tipo de vehículo no válido.");
                        break;
                    }
                    
                    // Peticion de la fila y la colmuna a la que se quiere agregar el nuevo vehiculo
                    System.out.print("Ingrese la fila del puesto: ");
                    int fila = scanner.nextInt();
                    System.out.print("Ingrese la columna del puesto: ");
                    int columna = scanner.nextInt();

                    // Ingreso del vehiculo al parqueadero gracias al metodo ingresarVehiculo
                    parqueadero.ingresarVehiculo(vehiculo, fila, columna);
                    break;

                
                // Caso de retiro de vehiculo
                case 2:
                    // Peticion de la fila y la columna a despachar
                    System.out.print("Ingrese la fila del puesto: ");
                    int filaRetirar = scanner.nextInt();
                    System.out.print("Ingrese la columna del puesto: ");
                    int columnaRetirar = scanner.nextInt();

                    // Uso del metodo retirarVehiculo
                    parqueadero.retirarVehiculo(filaRetirar, columnaRetirar);
                    break;

                // Caso de busqueda de vehiculo por puesto
                case 3:
                    // Peticion de la fila y la columna a buscar
                    System.out.print("Ingrese la fila del puesto: ");
                    int filaBuscar = scanner.nextInt();
                    System.out.print("Ingrese la columna del puesto: ");
                    int columnaBuscar = scanner.nextInt();

                    // Uso del metodo buscarVehiculoPorPuesto
                    Vehiculo vehiculoBuscado = parqueadero.buscarVehiculoPorPuesto(filaBuscar, columnaBuscar);
                    if (vehiculoBuscado != null) {
                        System.out.println("Vehículo en puesto (" + filaBuscar + ", " + columnaBuscar + "): " + vehiculoBuscado);
                    }
                    break;

                // caso de mostrar historial de ingresos
                case 4:
                    // Uso del metodo imprimirHistoricoIngresos
                    parqueadero.imprimirHistoricoIngresos();
                    break;
                
                // caso de graficacion de parqueadero
                case 5:
                    // Uso del metodo graficarParqueadero
                    parqueadero.graficarParqueadero();
                    break;

                // Caso de generacion de reporte diario
                case 6:
                    // Peticion de a fecha a analizar en formato año, mes y dia
                    System.out.print("Ingrese la fecha del reporte diario (yyyy-MM-dd): ");
                    String fechaStr = scanner.nextLine();
                    
                    /*
                    *   Se crea un objeto ´Date´ llamado fecha a partir de una cadena de texto ingresada anteriormente ´fechaStr´
                    *   la cual debe ingresar en el formato pedido. La clase SimpleDateFormat se utiliza para convertir la cadena de texto
                    *   en un objeto ´Date´
                    */
                    try {
                        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
                        parqueadero.generarReporteDiario(fecha); // Se llama al metodo generarReporteDiario
                    } catch (Exception e) {
                        // Mensaje de error si algo estuvo mal ingresado
                        System.out.println("Formato de fecha no válido.");
                    }
                    break;

                // Caso  de generacion de reporte mensual
                case 7:
                    // Peticion del mes y el año del reporte deseado
                    System.out.print("Ingrese el mes del reporte mensual (1-12): ");
                    int mes = scanner.nextInt();
                    System.out.print("Ingrese el año del reporte mensual: ");
                    int anio = scanner.nextInt();
                    parqueadero.generarReporteMensual(mes, anio); // Uso del metodo generarReporteMensual
                    break;

                // Caso del cierre del programa
                case 8:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                // Cualquier opcion por fuera de las válidas
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}