package componentes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class citas {

    private final ArrayList<cita> citas;

    public citas() {
        citas = new ArrayList<>();
    }

    public boolean CitaNueva() {
        String id;
        String fecha;
        String hora;
        String motivo;
        cita nuevaCita;

        id = JOptionPane.showInputDialog(null, "ID para la cita: ", "Nueva cita", JOptionPane.QUESTION_MESSAGE);
        fecha = JOptionPane.showInputDialog(null, "Fecha para la cita: ", "Nueva cita", JOptionPane.QUESTION_MESSAGE);
        hora = JOptionPane.showInputDialog(null, "Hora para la cita: ", "Nueva cita", JOptionPane.QUESTION_MESSAGE);
        motivo = JOptionPane.showInputDialog(null, "Motivo de la cita: ", "Nueva cita", JOptionPane.QUESTION_MESSAGE);
        nuevaCita = new cita(id, fecha, hora, motivo);
        return citas.add(nuevaCita);
    }

    public void Citas() {
        citas.forEach(c -> {
            c.mostrar();
        });
    }

    public boolean ModificarCita() {
        String id;
        cita cita;

        id = JOptionPane.showInputDialog(null, "Introduzca ID de la cita a modificar:",
                "Modificar cita", JOptionPane.QUESTION_MESSAGE);
        cita = null;
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getId().equals(id)) {
                cita = citas.get(i);
                break;
            }
        }
        if (cita == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra cita con el ID:\n" + id,
                    "Cita no encontrada", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {

            cita.setId(JOptionPane.showInputDialog(null, "ID actual: " + cita.getId()
                    + "\nIntroduzca nuevo ID:", "Modificar cita", JOptionPane.QUESTION_MESSAGE));
            cita.setFecha(JOptionPane.showInputDialog(null, "Fecha actual: " + cita.getFecha()
                    + "\nIntroduzca nueva fecha:", "Modificar cita", JOptionPane.QUESTION_MESSAGE));
            cita.setHora(JOptionPane.showInputDialog(null, "Hora cita: " + cita.getHora()
                    + "\nIntroduzca nueva hora:", "Modificar cita", JOptionPane.QUESTION_MESSAGE));
            cita.setMotivo(JOptionPane.showInputDialog(null, "Motivo cita: " + cita.getMotivo()
                    + "\nIntroduzca nuevo motivo:", "Modificar cita", JOptionPane.QUESTION_MESSAGE));
            return true;
        }
    }

    public boolean BorrarCita() {
        String id;
        cita cita;
        
        id = JOptionPane.showInputDialog(null, "Introduzca Identificador de la cita a borrar:",
                "Borrar cita", JOptionPane.QUESTION_MESSAGE);
        cita = null;
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getId().equals(id)) {
                cita = citas.remove(i);
            }
        }

        if (cita == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra cita con el ID:\n" + id,
                    "Cita no encontrado", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Se elimino la cita con ID:\n" + id,
                    "Cita Eliminado", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void archivoDB() {
        File archivo;
        File carpeta;
        
        archivo = new File("src/db/citas.csv");
        try {
            if (!archivo.exists()) {
                carpeta = archivo.getParentFile();
                carpeta.mkdirs();
                archivo.createNewFile();
            }
            try (FileWriter escritor = new FileWriter(archivo)) {
                escritor.append("#ID;Fecha;Hora;Motivo\n");
                for (cita cita : citas) {
                    escritor.append(cita.generarCSV());
                }
            }
        } catch (IOException e) {
            System.out.println("No existe la ruta: " + archivo.getAbsolutePath());
        }
    }
}
