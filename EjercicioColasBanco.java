package org.example.taller5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Banco {
    private Queue<String> fila;

    public Banco() {
        fila = new LinkedList<>();
    }

    public void agregarCliente(String cliente) {
        fila.offer(cliente);
        System.out.println(cliente + " se ha unido a la fila del banco.");
    }

    public void atenderCliente() {
        if (!fila.isEmpty()) {
            String cliente = fila.poll();
            System.out.println("Atendiendo a: " + cliente);
        } else {
            System.out.println("No hay clientes en la fila.");
        }
    }

    public void mostrarFila() {
        if (!fila.isEmpty()) {
            System.out.println("Clientes en la fila:");
            for (String cliente : fila) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("La fila del banco está vacía.");
        }
    }
}

public class EjercicioColasBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar cliente a la fila");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar fila de clientes");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String cliente = scanner.nextLine();
                    banco.agregarCliente(cliente);
                    break;
                case 2:
                    banco.atenderCliente();
                    break;
                case 3:
                    banco.mostrarFila();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 4.");
            }
        }
    }
}
