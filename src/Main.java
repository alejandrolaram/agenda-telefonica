import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        // Carga inicial de datos al arrancar el programa
        addressBook.load();

        int option = 0;

        do {
            System.out.println("\n--- MENÚ AGENDA TELEFÓNICA ---");
            System.out.println("1. Mostrar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido del 1 al 5.");
                continue;
            }

            switch (option) {
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("Ingresa el número telefónico: ");
                    String phone = scanner.nextLine().trim();
                    if (phone.isEmpty()) {
                        System.out.println("El número no puede estar vacío.");
                        break;
                    }
                    System.out.print("Ingresa el nombre: ");
                    String name = scanner.nextLine().trim();
                    addressBook.create(phone, name);
                    break;
                case 3:
                    System.out.print("Ingresa el número telefónico a eliminar: ");
                    String phoneToDelete = scanner.nextLine().trim();
                    addressBook.delete(phoneToDelete);
                    break;
                case 4:
                    addressBook.save();
                    break;
                case 5:
                    // Respaldo automático antes de cerrar la aplicación
                    System.out.println("Guardando datos antes de salir...");
                    addressBook.save();
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (option != 5);

        scanner.close();
    }
}