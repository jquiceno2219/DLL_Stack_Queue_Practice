package org.example.taller5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Banco {
    private Queue<String> fila;//se crea la lista/fila

    public Banco() {
        fila = new LinkedList<>();
    }

    public void agregarCliente(String cliente) {
        fila.offer(cliente);
        System.out.println(cliente + " se ha unido a la fila del banco.");//imprime el cliente que ingresa a la fila
    }

    public void atenderCliente() {
        if (!fila.isEmpty()) {
            String cliente = fila.poll();
            System.out.println("Atendiendo a: " + cliente);//elimina al cliente que esta de primero en la fila
        } else {
            System.out.println("No hay clientes en la fila.");//no hay elementos en la lista
        }
    }

    public void mostrarFila() {
        if (!fila.isEmpty()) {
            System.out.println("Clientes en la fila:");//imprime a los clientes en la lista
            for (String cliente : fila) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("La fila del banco está vacía.");//no hay clientes
        }
    }
}

public class EjercicioColasBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {//menu principal
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar cliente a la fila");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar fila de clientes");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");//se ingresa el cliente con el nombre
                    String cliente = scanner.nextLine();
                    banco.agregarCliente(cliente);//se añade
                    break;
                case 2:
                    banco.atenderCliente();//se elimina el primer cliente en la fila
                    break;
                case 3:
                    banco.mostrarFila();//se imprime la fila de clientes
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");//cierre del programa
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 4.");
            }
        }
    }
}
