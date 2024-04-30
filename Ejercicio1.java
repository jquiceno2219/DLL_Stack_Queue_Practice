package org.example.taller5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EditorTexto {
    private List<String> operaciones;
    private List<String> deshacer;
    private List<String> rehacer;

    public EditorTexto() {
        operaciones = new ArrayList<>();
        deshacer = new ArrayList<>();
        rehacer = new ArrayList<>();
    }

    public void ingresarOperacion(String operacion) {
        operaciones.add(operacion);
        System.out.println("Texto ingresado: " + operacion);
    }

    public void guardar() {
        operaciones.clear();
        System.out.println("Textos guardados.");
    }

    public void deshacer() {
        if (!operaciones.isEmpty()) {
            String operacion = operaciones.remove(operaciones.size() - 1);
            deshacer.add(operacion);
            System.out.println("Texto deshecho: " + operacion);
        } else {
            System.out.println("No hay textos para deshacer.");
        }
    }

    public void rehacer() {
        if (!deshacer.isEmpty()) {
            String operacion = deshacer.remove(deshacer.size() - 1);
            operaciones.add(operacion);
            System.out.println("Texto rehecho: " + operacion);
        } else {
            System.out.println("No hay texto para rehacer.");
        }
    }

    public void imprimirOperaciones() {
        System.out.println("Textos establecidps:");
        for (int i = 0; i < operaciones.size(); i++) {
            System.out.println((i + 1) + ". " + operaciones.get(i));
        }
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Guardar");
            System.out.println("3. Deshacer");
            System.out.println("4. Rehacer");
            System.out.println("5. Imprimir todas los textos");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el texto: ");
                    String operacion = scanner.nextLine();
                    editor.ingresarOperacion(operacion);
                    break;
                case 2:
                    editor.guardar();
                    break;
                case 3:
                    editor.deshacer();
                    break;
                case 4:
                    editor.rehacer();
                    break;
                case 5:
                    editor.imprimirOperaciones();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 6.");
            }
        }
    }
}
