package Estudiante;

public class Gestor {
    private EstudianteCRUD estudianteCRUD;

    public Gestor() {
        estudianteCRUD = new EstudianteCRUD();
    }

    public EstudianteCRUD getEstudianteCRUD(){
        return estudianteCRUD;
    }
}
