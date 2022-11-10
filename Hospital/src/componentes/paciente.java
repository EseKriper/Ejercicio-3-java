package componentes;

public class paciente {
    private String id;
    private String nombre;
    private String apellido;

    paciente(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String archivoDB() {
        return String.format("%s;%s;%s;\n", id, nombre, apellido);
    }

    public void mostrar() {
        System.out.println("\nID: " + id
                + "\nNombre: " + nombre
                + "\nApellido: " + apellido + "\n");
    }
}
