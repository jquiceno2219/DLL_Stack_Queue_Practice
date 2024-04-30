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

    public void ingresarOperacion(String[][] operacion) {//ingresa una hoja de calculo y reemplaza la anterior
        while (indiceActual < operaciones.size() - 1) {
            operaciones.remove(operaciones.size() - 1);
        }
        operaciones.add(operacion);
        indiceActual++;
        System.out.println("Operación ingresada.");
    }

    public void deshacer() {//deshace la hoja de calculo ingresada
        if (indiceActual >= 0) {
            indiceActual--;
            System.out.println("Operación deshecha.");
        } else {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    public void rehacer() {//rehace la hoja de calculo eliminada
        if (indiceActual < operaciones.size() - 1) {
            indiceActual++;
            System.out.println("Operación rehecha.");
        } else {
            System.out.println("No hay operaciones para rehacer.");
        }
    }

    public void imprimirHojaActual() {//imprime la hoja de calculo actual
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
            System.out.println("No hay hoja de cálculo disponible.");//condicional para indicar que no hay hoja de calculo
        }
    }
}

public class EjercicioPilasExcel {
    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo();
        Scanner scanner = new Scanner(System.in);

        while (true) {//menu principal
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ingresar operación (nueva hoja de cálculo)");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Imprimir hoja de cálculo actual");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese las dimensiones de la hoja de cálculo (filas columnas): ");//se indica el ingreso del tamaño de la hoja de calculo
                    int filas = scanner.nextInt();
                    int columnas = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea después de nextInt()

                    String[][] hojaNueva = new String[filas][columnas];
                    System.out.println("Ingrese los datos de la hoja de cálculo:");//se ingresa los datos en la hoja de calculo
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            hojaNueva[i][j] = scanner.next();
                        }
                    }
                    hoja.ingresarOperacion(hojaNueva);//añade/reemplaza la hoja de calculo
                    break;
                case 2:
                    hoja.deshacer();//deshace la hoja de calculo
                    break;
                case 3:
                    hoja.rehacer();//rehace la hoja de calculo eliminada/reemplazada
                    break;
                case 4:
                    hoja.imprimirHojaActual();//imprime la hoja de calculo en estilo de una matriz
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");//cierre de programa
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 5.");
            }
        }
    }
}

