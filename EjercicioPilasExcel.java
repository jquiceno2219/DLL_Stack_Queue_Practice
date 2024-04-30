package org.example.taller5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HojaCalculo {
    private List<String[][]> operaciones;
    private int indiceActual;

    public HojaCalculo() {
        operaciones = new ArrayList<>();
        indiceActual = -1; // No hay operaciones inicialmente
    }

    public void ingresarOperacion(String[][] operacion) {
        // Eliminar las operaciones que están adelante en el historial
        while (indiceActual < operaciones.size() - 1) {
            operaciones.remove(operaciones.size() - 1);
        }
        operaciones.add(operacion);
        indiceActual++;
        System.out.println("Operación ingresada.");
    }

    public void deshacer() {
        if (indiceActual >= 0) {
            indiceActual--;
            System.out.println("Operación deshecha.");
        } else {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    public void rehacer() {
        if (indiceActual < operaciones.size() - 1) {
            indiceActual++;
            System.out.println("Operación rehecha.");
        } else {
            System.out.println("No hay operaciones para rehacer.");
        }
    }

    public void imprimirHojaActual() {
        if (indiceActual >= 0 && indiceActual < operaciones.size()) {
            String[][] hoja = operaciones.get(indiceActual);
            System.out.println("Hoja de cálculo actual:");
            for (String[] fila : hoja) {
                for (String celda : fila) {
                    System.out.print(celda + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay hoja de cálculo disponible.");
        }
    }
}

public class EjercicioPilasExcel {
    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ingresar operación (nueva hoja de cálculo)");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Imprimir hoja de cálculo actual");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese las dimensiones de la hoja de cálculo (filas columnas): ");
                    int filas = scanner.nextInt();
                    int columnas = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea después de nextInt()

                    String[][] hojaNueva = new String[filas][columnas];
                    System.out.println("Ingrese los datos de la hoja de cálculo:");
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            hojaNueva[i][j] = scanner.next();
                        }
                    }
                    hoja.ingresarOperacion(hojaNueva);
                    break;
                case 2:
                    hoja.deshacer();
                    break;
                case 3:
                    hoja.rehacer();
                    break;
                case 4:
                    hoja.imprimirHojaActual();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 5.");
            }
        }
    }
}

