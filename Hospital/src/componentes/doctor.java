package componentes;

public class doctor {

    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;

    public doctor(String id, String nombre, String apellido, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public String TomarID() {
        return id;
    }

    public void DefinirID(String id) {
        this.id = id;
    }

    public String TomarNombre() {
        return nombre;
    }

    public void DefinirNombre(String nombre) {
        this.nombre = nombre;
    }

    public String TomarApellido() {
        return apellido;
    }

    public void DefinirApellido(String apellido) {
        this.apellido = apellido;
    }

    public String TomarArea() {
        return especialidad;
    }

    public void DefinirArea(String especialidad) {
        this.especialidad = especialidad;
    }

    public String archivoDB() {
        return String.format("%s;%s;%s;%s\n", id, nombre, apellido, especialidad);
    }

    public void mostrar() {
        System.out.println("\nID: " + id
                + "\nNombre: " + nombre
                + "\nApellido: " + apellido
                + "\nEspecialidad: " + especialidad + "\n");
    }
}
