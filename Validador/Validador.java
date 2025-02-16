package Validador;

public class Validador {
    public static boolean validarId(int id) {
        return id > 0;
    }

    public static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }
}
