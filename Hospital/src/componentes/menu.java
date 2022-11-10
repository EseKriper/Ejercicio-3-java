package componentes;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {

    private static final ArrayList<admin> administradores = new ArrayList<>();
    private static final Scanner sn = new Scanner(System.in);
    static pacientes pacientes = new pacientes();
    static doctores doctores = new doctores();
    static citas citas = new citas();

    public static void main(String[] args) {
        int decision;
        boolean salir;

        decision = 0;
        salir = false;

        admin();
        if (inicio()) {
            System.out.println("Usuario autorizado");
        } else {
            System.out.println("Usuario no autorizado");
            System.exit(0);
        }

        while (!salir) {
            System.out.println("1. Añadir un medico\n"
                    + "2. Añadir un paciente\n"
                    + "3. Crear una cita\n"
                    + "4. Lista de medicos\n"
                    + "5. Lista de pacientes\n"
                    + "6. Lista de citas\n"
                    + "7. Borrar medico\n"
                    + "8. Borrar paciente\n"
                    + "9. Borrar Cita\n"
                    + "10. Salir");
            decision = sn.nextInt();
            switch (decision) {
                case 1 -> {
                    doctores.DoctorNuevo();
                    doctores.archivoDB();
                }
                case 2 -> {
                    pacientes.PacienteNuevo();
                    pacientes.archivoDB();
                }
                case 3 -> {
                    citas.CitaNueva();
                    citas.archivoDB();
                }
                case 4 ->
                    doctores.Doctores();
                case 5 ->
                    pacientes.Pacientes();
                case 6 ->
                    citas.Citas();
                case 7 ->
                    doctores.BorrarDoctor();
                case 8 ->
                    pacientes.BorrarPaciente();
                case 9 ->
                    citas.BorrarCita();
                case 10 ->
                    salir = true;
            }
        }
    }

    public static void admin() {
        administradores.add(new admin("ADMIN", "ROOT"));
    }

    public static boolean inicio() {
        String nombre;
        String password;
        admin admin;
        
        System.out.println("Inicio de sesión");
        System.out.println("-------------------");
        System.out.println("Usuario: ");
        nombre = sn.nextLine();
        System.out.println("Contraseña: ");
        password = sn.nextLine();
        admin = new admin(nombre, password);
        return administradores.contains(admin);
    }

}
