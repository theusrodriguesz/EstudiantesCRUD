package EstudiantesApp;

import Estudiante.*;
import Input.Input;

public class EstudiantesApp {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        EstudianteCRUD estudianteCRUD = gestor.getEstudianteCRUD();

        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Crear 2 Estudiantes");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Actualizar Nota");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Salir");
            opcion = Input.obtenerInt("Selecciona una opción:");

            switch (opcion) {
                case 1:
                    for (int i = 0; i < 2; i++) {  // Crear 2 estudiantes
                        System.out.println("Introduce los datos del estudiante " + (i + 1));
                        int id = Input.obtenerInt("Introduce el ID del estudiante:");
                        String nombre = Input.obtenerString("Introduce el nombre completo del estudiante:");
                        int edad = Input.obtenerInt("Introduce la edad del estudiante:");
                        String fechaNacimiento = Input.obtenerString("Introduce la fecha de nacimiento del estudiante (DD/MM/AAAA):");

                        String asignatura1Nombre = Input.obtenerString("Introduce el nombre de la primera asignatura:");
                        double asignatura1Nota = Input.obtenerDouble("Introduce la nota de la primera asignatura:");
                        String asignatura2Nombre = Input.obtenerString("Introduce el nombre de la segunda asignatura:");
                        double asignatura2Nota = Input.obtenerDouble("Introduce la nota de la segunda asignatura:");

                        Asignatura asignatura1 = new Asignatura(asignatura1Nombre, asignatura1Nota);
                        Asignatura asignatura2 = new Asignatura(asignatura2Nombre, asignatura2Nota);
                        Estudiante estudiante = new Estudiante(id, nombre, edad, fechaNacimiento, new Asignatura[]{asignatura1, asignatura2});

                        estudianteCRUD.crearEstudiante(estudiante);
                    }
                    break;

                case 2:
                    estudianteCRUD.listarEstudiantes();
                    break;

                case 3:
                    int idModificar = Input.obtenerInt("Introduce el ID del estudiante para modificar la nota:");
                    String asignaturaModificar = Input.obtenerString("Introduce el nombre de la asignatura para modificar la nota:");
                    double nuevaNota = Input.obtenerDouble("Introduce la nueva nota:");
                    estudianteCRUD.actualizarNota(idModificar, asignaturaModificar, nuevaNota);
                    break;

                case 4:
                    int idEliminar = Input.obtenerInt("Introduce el ID del estudiante para eliminar:");
                    estudianteCRUD.eliminarEstudiante(idEliminar);
                    break;

                case 5:
                    System.out.println("¡Adiós! ");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 5);
    }
}
