# Simulador de Agenda Telefónica en Java

Este proyecto consiste en una aplicación de consola en Java que simula una agenda telefónica (`AddressBook`). El sistema permite la gestión de contactos y cuenta con persistencia de datos mediante un archivo de texto plano en formato CSV.

## Características

*   **Estructura de Datos:** Uso de `HashMap` (`Map<String, String>`) donde el número telefónico actúa como la llave única y el nombre como el valor.
*   **Persistencia:** Lectura (`load`) y escritura (`save`) automática y manual en un archivo local llamado `contacts.csv`.
*   **Interfaz de Consola:** Menú interactivo con operaciones CRUD básicas:
    *   Listar contactos en formato `{Número} : {Nombre}`.
    *   Crear o actualizar contactos.
    *   Eliminar contactos mediante el número telefónico.

## Estructura del Proyecto

*   `src/AddressBook.java`: Contiene la lógica del negocio, el mapa de almacenamiento y los métodos de entrada/salida de archivos (I/O).
*   `src/Main.java`: Contiene el punto de entrada de la aplicación, el ciclo del menú y la captura de datos por consola.

## Requisitos y Ejecución

*   Java JDK.
*   Ejecutar la clase `Main.java` desde cualquier IDE o mediante la terminal del sistema operativo.