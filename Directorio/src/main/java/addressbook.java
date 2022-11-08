import java.util.*;
import java.io.*;

public class addressbook {
    public static void main(String[] args) {
        
        HashMap<String, String> contactos;
        int opcion, principal = 0;
        String telefono, nombre;
        Scanner lectura;
        
        contactos = new HashMap<>();   
        lectura = new Scanner(System.in);
        
        System.out.println("\n**DIRECTORIO TELEFONICO**\n");
        do
        {
            try{
            System.out.println("---------Acción a realizar-----------");
                System.out.println("| Cargar archivo  \t\t  1 |");
                System.out.println("| Guardar archivo \t\t  2 |");
                System.out.println("| Mostrar directorio \t\t  3 |");
                System.out.println("| Añadir numero  \t\t  4 |");
                System.out.println("| Borrar contacto \t\t  5 |");
                System.out.println("| Cerrar  \t\t\t  6 |");
                System.out.println("-------------------------------------\n");
                opcion = lectura.nextInt();
                switch(opcion)
                {
                    case 1 -> load(contactos);
                    case 2 -> save(contactos);
                    case 3 -> list(contactos);
                    case 4 -> {
                        System.out.println("Nuevo telefono: ");
                        telefono = lectura.next();
                        System.out.println("Nombre para el telefono: ");
                        nombre = lectura.next();
                        create(contactos,telefono,nombre);
                    }
                    case 5 -> {
                        System.out.println("Numero de telefono a eliminar: ");
                        telefono = lectura.next();
                        delete(contactos, telefono);
                    }
                    case 6 -> {
                        System.out.println("Cerrando\n");
                        principal = 1;
                    }
                    default -> System.out.println("Opción incorrecta.\n");
                }
            }
            catch (Exception e)
            {
                System.out.println("¡¡ERROR!!\n");
                break;
            }
        }while(principal == 0);
    }
    
    public static void load(HashMap<String, String> m)
    {
        String archivo;
        archivo = "D:\\Documents\\NetBeansProjects\\Directorio\\src\\main\\java\\contact.csv";
        String insertar [];
        BufferedReader Lector;
        Lector = null;
        try {
            Lector = new BufferedReader(new FileReader(archivo));

            String line;
            while ((line = Lector.readLine()) != null) {
                insertar = line.split(",");
                m.put(insertar[0],insertar[1]);
            }
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (Lector != null) {
                    Lector.close();
                    System.out.println("\nContactos cargados.");
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
    
    public static void save(HashMap<String, String> m)
    {
        Iterator<String> iterador;
        iterador = m.keySet().iterator();
        String archivo = "D:\\Documents\\NetBeansProjects\\Directorio\\src\\main\\java\\contact.csv"; 
        
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(archivo));
           while(iterador.hasNext())
        {
            String contacto;
            contacto = iterador.next();
            bufferedWriter.write(contacto+","+m.get(contacto)+"\n");
        }
            }
         catch(IOException e) {
            System.out.println("IOException catched while writing: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    System.out.println("\nDatos guardados correctamente.");
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
    
    public static void list(HashMap<String, String> contactos)
    {
        Iterator<String> iterador;
        iterador = contactos.keySet().iterator();
        
        System.out.println("Contactos:\n");
        System.out.println("  Telefono\t|\tNombre   ");
        System.out.println("----------------------------------");
        while(iterador.hasNext())
        {
            String contacto;
            contacto = iterador.next();
            System.out.println("  "+contacto+"\t|\t"+contactos.get(contacto));
        } System.out.println("\n");
    }
    
    public static void create(HashMap<String, String> contactos, String tel, String nom)
    {           
            if(contactos.containsKey(tel)){
                System.out.println("\nError!\nEste numero ya esta registrado\n");
            }
            else{
                contactos.put(tel, nom);
                System.out.println("\nContacto agregado");
            }
    }
    
    public static void delete(HashMap<String, String> contactos, String tel)
    {
        if(contactos.containsKey(tel))
        {  
            System.out.println("\nContacto eliminado: "+contactos.get(tel)+"\n");
            contactos.remove(tel);
        }
        else
            System.out.println("\nEste telefono no existe.\n");
    }
}