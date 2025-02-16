package Estudiante;

import java.util.ArrayList;
import java.util.Iterator;
import Validador.Validador;

public class EstudianteCRUD {
    private ArrayList<Estudiante> estudiantes;

    public EstudianteCRUD() {
        estudiantes = new ArrayList<>();
    }

    public void crearEstudiante(Estudiante estudiante) {
        if (Validador.validarId(estudiante.getId())) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante agregado exitosamente.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.println("id   | Nombre Completo          | Asignatura 1 (Nota)     | Asignatura 2 (Nota)");
        System.out.println("-----|--------------------------|-------------------------|------------------------");

        for (Estudiante estudiante : estudiantes) {
            String nombre = estudiante.getNombreCompleto();
            Asignatura asignatura1 = estudiante.getAsignaturas()[0];
            Asignatura asignatura2 = estudiante.getAsignaturas()[1];

            System.out.printf("%-5d| %-25s| %-23s| %-23s%n",
                    estudiante.getId(),
                    nombre,
                    asignatura1.getNombre() + " (" + String.format("%.1f", asignatura1.getNota()) + ")",
                    asignatura2.getNombre() + " (" + String.format("%.1f", asignatura2.getNota()) + ")");
        }
    }

    public void actualizarNota(int id, String nombreAsignatura, double nuevaNota) {
        if (!Validador.validarNota(nuevaNota)) {
            System.out.println("Nota no válida.");
            return;
        }

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                for (Asignatura asignatura : estudiante.getAsignaturas()) {
                    if (asignatura.getNombre().equalsIgnoreCase(nombreAsignatura)) {
                        asignatura.setNota(nuevaNota);
                        System.out.println("Nota actualizada con éxito.");
                        return;
                    }
                }
            }
        }
        System.out.println("Estudiante o asignatura no encontrado.");
    }

    public void eliminarEstudiante(int id) {
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getId() == id) {
                iterator.remove();
                System.out.println("Estudiante eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
}
