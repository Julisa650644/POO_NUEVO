/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */



public class BibliotecaDemo {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros al catálogo con nuevos datos
        biblioteca.agregarLibro(new Libro("978-8478884452", "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico"));
        biblioteca.agregarLibro(new Libro("978-8497932419", "El amor en los tiempos del cólera", "Gabriel García Márquez", "Romance"));
        biblioteca.agregarLibro(new Libro("978-0140449266", "La Odisea", "Homero", "Épica"));

        // Registrar nuevos usuarios en la biblioteca
        biblioteca.registrarUsuario(new Persona("P001", "María"));
        biblioteca.registrarUsuario(new Persona("P002", "Carlos"));

        // Prestar libros a los usuarios registrados
        biblioteca.prestarLibro("P001", "978-8478884452");  // María presta "Cien años de soledad"
        biblioteca.prestarLibro("P002", "978-0140449266");  // Carlos presta "La Odisea"

        // Listar libros prestados a María
        System.out.println("Libros prestados a María:");
        for(Libro libro : biblioteca.listarLibrosPrestados("P001")) {
            System.out.println(libro);
        }

        // Buscar libros por autor "Gabriel García Márquez"
        System.out.println("\nLibros de 'Gabriel García Márquez':");
        for(Libro libro : biblioteca.buscarPorAutor("Gabriel García Márquez")) {
            System.out.println(libro);
        }

        // María devuelve el libro prestado
        biblioteca.devolverLibro("P001", "978-8478884452");

        // Intentar eliminar usuario Carlos (debería fallar porque tiene libro prestado)
        biblioteca.eliminarUsuario("P002");

        // Carlos devuelve su libro y luego es eliminado
        biblioteca.devolverLibro("P002", "978-0140449266");
        biblioteca.eliminarUsuario("P002");

        // Quitar un libro del catálogo
        biblioteca.quitarLibro("978-8497932419");
    }
}
