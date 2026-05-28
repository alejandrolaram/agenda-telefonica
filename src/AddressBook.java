import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    // Estructura para almacenar contactos (Llave: Teléfono, Valor: Nombre)
    private Map<String, String> contacts;
    private final String filename = "contacts.csv";

    public AddressBook() {
        this.contacts = new HashMap<>();
    }

    // Carga los datos del archivo CSV al HashMap
    public void load() {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No se encontró un archivo previo, se creará uno nuevo al guardar.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            contacts.clear();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // Separa la línea por la primera coma encontrada
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    contacts.put(parts[0].trim(), parts[1].trim());
                }
            }
            System.out.println("Contactos cargados exitosamente (" + contacts.size() + ").");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    // Guarda el contenido actual del HashMap en el archivo CSV
    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
            System.out.println("Cambios guardados en el archivo con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    // Muestra los contactos en la consola con el formato requerido
    public void list() {
        System.out.println("\nContactos:");
        if (contacts.isEmpty()) {
            System.out.println("(La agenda está vacía)");
            return;
        }
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Agrega un contacto o actualiza el nombre si el número ya existe
    public void create(String phone, String name) {
        if (contacts.containsKey(phone)) {
            System.out.println("El número ya existe, se actualizará el nombre.");
        }
        contacts.put(phone, name);
        System.out.println("Contacto agregado/actualizado.");
    }

    // Elimina un contacto del mapa usando el número como llave
    public void delete(String phone) {
        if (contacts.containsKey(phone)) {
            String removedName = contacts.remove(phone);
            System.out.println("Contacto '" + removedName + "' eliminado correctamente.");
        } else {
            System.out.println("El número de teléfono no existe en la agenda.");
        }
    }
}