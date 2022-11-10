package componentes;

public class admin {
    private final String nombre;
    private final String password;

    public admin(String name, String pass) {
        nombre = name;
        password = pass;
    }

    public boolean equals(Object objeto) {
        if (objeto instanceof admin) {
            admin otroAdmin = (admin) objeto;
            return nombre.equals(otroAdmin.nombre) && password.equals(otroAdmin.password);
        } else {
            return false;
        }
    }
}
