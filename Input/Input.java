package Input;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);


    public static String obtenerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int obtenerInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido. ");
            scanner.next();
            System.out.print(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }


    public static double obtenerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, introduce un número decimal válido.");
            scanner.next();  // Consumir la entrada incorrecta
            System.out.print(mensaje);
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea
        return valor;
    }
}
