package Estudiante;

public class Estudiante {
    private int id;
    private String nombreCompleto;
    private int edad;
    private String fechaNacimiento;
    private Asignatura[] asignaturas;

    public Estudiante(int id, String nombreCompleto, int edad, String fechaNacimiento, Asignatura[] asignaturas) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.asignaturas = asignaturas;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }
}
