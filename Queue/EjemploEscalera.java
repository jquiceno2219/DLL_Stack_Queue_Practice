package DLL_Stack_Queue_Practice.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Escalera {
    private Queue<String> fila;//se crea la lista/fila

    public Escalera() {
        fila = new LinkedList<>();
    }

    //Alguien sube a la escalera
    public void subirPersona(String persona) {
        fila.offer(persona);
        System.out.println(persona + " se ha subido a la escalera.");//imprime la persona que sube a escalera
    }

    //Simular mover la escalera
    public void moverEscalera() {
        if (!fila.isEmpty()) {
            //Poll sirve para extraer la cabeza de la cola
            String persona = fila.poll();
            System.out.println("Moviendo escalera");
            System.out.println(persona + " ha bajado de la escalera.");//elimina a la persona que esta de primera en la escalera
        } else {
            System.out.println("La escalera está vacía.");//no hay elementos en la lista
        }
    }

    public void mostrarEscalera() {
        if (!fila.isEmpty()) {
            System.out.println("Personas en la fila:");//imprime a las personas en la escalera
            for (String persona : fila) {
                System.out.println(persona);
            }
        } else {
            System.out.println("La escalera  está vacía.");//no hay personas
        }
    }
}

public class EjemploEscalera {
    public static void main(String[] args) {
        Escalera escalera = new Escalera();
        Scanner scanner = new Scanner(System.in);

        while (true) {//menu principal
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Subir persona a la escalera");
            System.out.println("2. Mover escalera");
            System.out.println("3. Mostrar personas en la escalera");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la persona: ");//se ingresa el nombre
                    String persona = scanner.nextLine();
                    escalera.subirPersona(persona);//se sube
                    break;
                case 2:
                    escalera.moverEscalera();//se elimina la primera persona en la fila
                    break;
                case 3:
                    escalera.mostrarEscalera();//se imprime la fila
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