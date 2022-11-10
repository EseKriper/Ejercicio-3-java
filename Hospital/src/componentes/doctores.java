package componentes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class doctores {

    private final ArrayList<doctor> doctores;

    public doctores() {
        doctores = new ArrayList<>();
    }

    public boolean DoctorNuevo() {
        String id;
        String nombre;
        String apellido;
        String especialidad;
        doctor nuevoDoctor;
        
        id = JOptionPane.showInputDialog(null, "Ingresa ID doctor: ", "Nuevo doctor", JOptionPane.QUESTION_MESSAGE);
        nombre = JOptionPane.showInputDialog(null, "Nombre doctor: ", "Nuevo doctor", JOptionPane.QUESTION_MESSAGE);
        apellido = JOptionPane.showInputDialog(null, "Apellido doctor: ", "Nuevo doctor", JOptionPane.QUESTION_MESSAGE);
        especialidad = JOptionPane.showInputDialog(null, "Especialidad: ", "Nuevo doctor", JOptionPane.QUESTION_MESSAGE);
        nuevoDoctor = new doctor(id, nombre, apellido, especialidad);
        return doctores.add(nuevoDoctor);
    }

    public void Doctores() {
        doctores.forEach(d -> {
            d.mostrar();
        });
    }

    public boolean ModificarDoctor() {
        String id;
        doctor doctor;
        
        id = JOptionPane.showInputDialog(null, "Introduzca ID del doctor a modificar:",
                "Modificar Doctor", JOptionPane.QUESTION_MESSAGE);
        doctor = null;
        for (int i = 0; i < doctores.size(); i++) {
            if (doctores.get(i).TomarID().equals(id)) {
                doctor = doctores.get(i);
                break;
            }
        }
        if (doctor == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra un doctor con el ID:\n" + id,
                    "Doctor no encontrado", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {

            doctor.DefinirID(JOptionPane.showInputDialog(null, "ID actual: " + doctor.TomarID()
                    + "\nIntroduzca nuevo ID:", "Modificar doctor", JOptionPane.QUESTION_MESSAGE));
            doctor.DefinirNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + doctor.TomarNombre()
                    + "\nIntroduzca nuevo nombre:", "Modificar doctor", JOptionPane.QUESTION_MESSAGE));
            doctor.DefinirApellido(JOptionPane.showInputDialog(null, "Apellidos Doctor: " + doctor.TomarApellido()
                    + "\nIntroduzca nuevo apellido:", "Modificar doctor", JOptionPane.QUESTION_MESSAGE));
            doctor.DefinirArea(JOptionPane.showInputDialog(null, "Especialidad Doctor: " + doctor.TomarArea()
                    + "\nIntroduzca nueva especialidad:", "Modificar doctor", JOptionPane.QUESTION_MESSAGE));
            return true;
        }
    }

    public boolean BorrarDoctor() {
        String id;
        doctor doctor;
        
        id = JOptionPane.showInputDialog(null, "Introduzca ID del doctor a borrar:",
                "Borrar Doctor", JOptionPane.QUESTION_MESSAGE);
        doctor = null;
        for (int i = 0; i < doctores.size(); i++) {
            if (doctores.get(i).TomarID().equals(id)) {
                doctor = doctores.remove(i);
            }
        }
        if (doctor == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra doctor con el ID:\n" + id,
                    "Doctor no encontrado", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Se elimino el doctor con ID:\n" + id,
                    "Doctor Eliminado", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void archivoDB() {
        File archivo;
        FileWriter escritor;
        
        archivo = new File("src/db/doctores.csv");
        try {
            if (!archivo.exists()) {
                File carpeta = archivo.getParentFile();
                carpeta.mkdirs();
                archivo.createNewFile();
            }
            escritor = new FileWriter(archivo);
            escritor.append("#ID;Nombre;Apellido;Especialidad\n");
            for (doctor doctor : doctores) {
                escritor.append(doctor.archivoDB());
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("No existe la ruta: " + archivo.getAbsolutePath());
        }
    }

}
