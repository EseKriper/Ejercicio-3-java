package componentes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class pacientes {

    private final ArrayList<paciente> pacientes;

    public pacientes() {
        pacientes = new ArrayList<>();
    }

    public boolean PacienteNuevo() {
        String id;
        String apellidos;
        String nombre;
        paciente nuevoPaciente;

        id = JOptionPane.showInputDialog(null, "Ingresa ID del paciente: ", "Nuevo paciente", JOptionPane.QUESTION_MESSAGE);
        nombre = JOptionPane.showInputDialog(null, "Nombre del paciente: ", "Nuevo paciente", JOptionPane.QUESTION_MESSAGE);
        apellidos = JOptionPane.showInputDialog(null, "Apellido del paciente: ", "Nuevo paciente", JOptionPane.QUESTION_MESSAGE);
        nuevoPaciente = new paciente(id, nombre, apellidos);
        return pacientes.add(nuevoPaciente);
    }

    public void Pacientes() {
        for (paciente p : pacientes) {
            p.mostrar();
        }
    }

    public boolean ModificarPaciente() {
        String id;
        paciente paciente;

        id = JOptionPane.showInputDialog(null, "Introduzca ID del paciente a modificar:",
                "Modificar Paciente", JOptionPane.QUESTION_MESSAGE);
        paciente = null;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).TomarID().equals(id)) {
                paciente = pacientes.get(i);
                break;
            }
        }
        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra un paciente con el ID:\n" + id,
                    "Paciente no encontrado", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            paciente.DefinirID(JOptionPane.showInputDialog(null, "ID actual: " + paciente.TomarID()
                    + "\nIntroduzca nuevo ID:", "Modificar paciente", JOptionPane.QUESTION_MESSAGE));
            paciente.DefinirNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + paciente.TomarNombre()
                    + "\nIntroduzca nuevo nombre:", "Modificar paciente", JOptionPane.QUESTION_MESSAGE));
            paciente.DefinirApellido(JOptionPane.showInputDialog(null, "Apellidos actuales: " + paciente.TomarApellido()
                    + "\nIntroduzca nuevos apellido:", "Modificar paciente", JOptionPane.QUESTION_MESSAGE));
            return true;
        }
    }

    public boolean BorrarPaciente() {
        String id;
        paciente paciente;

        id = JOptionPane.showInputDialog(null, "Introduzca ID del paciente a borrar:",
                "Borrar Paciente", JOptionPane.QUESTION_MESSAGE);
        paciente = null;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).TomarID().equals(id)) {
                paciente = pacientes.remove(i);
            }
        }
        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra un paciente con el ID:\n" + id,
                    "Paciente no encontrado", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Se elimino el paciente con ID:\n" + id,
                    "Paciente Eliminado", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void archivoDB() {
        File archivo;
        FileWriter escritor;
        
        archivo = new File("src/db/pacientes.csv");
        try {
            if (!archivo.exists()) {
                File carpeta = archivo.getParentFile();
                carpeta.mkdirs();
                archivo.createNewFile();
            }
            escritor = new FileWriter(archivo);
            escritor.append("#ID;Nombre;Apellido;\n");
            for (paciente paciente : pacientes) {
                escritor.append(paciente.archivoDB());
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("No existe la ruta: " + archivo.getAbsolutePath());
        }
    }

}
