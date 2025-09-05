/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;
import java.util.*;
/**
 *
 * @author User
 */
// Clase que gestiona el catálogo, usuarios y préstamos
public class Biblioteca {
    private Map<String, Libro> catalogoPorIsbn;     // Catálogo de libros por ISBN
    private Map<String, Persona> usuariosPorId;     // Registro de usuarios por ID
    private Set<String> isbnsPrestados;             // Conjunto de libros actualmente prestados

    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }

    // Agrega un libro al catálogo si no existe
    public boolean agregarLibro(Libro libro) {
        if (catalogoPorIsbn.containsKey(libro.getIsbn())) {
            System.out.println("El libro ya existe en el catálogo.");
            return false;
        }
        catalogoPorIsbn.put(libro.getIsbn(), libro);
        System.out.println("Libro agregado correctamente.");
        return true;
    }

    // Elimina un libro si no está prestado
    public boolean quitarLibro(String isbn) {
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("No se puede quitar un libro que está prestado.");
            return false;
        }
        if (catalogoPorIsbn.remove(isbn) != null) {
            System.out.println("Libro eliminado del catálogo.");
            return true;
        } else {
            System.out.println("El libro no existe.");
            return false;
        }
    }

    // Registra un nuevo usuario
    public boolean registrarUsuario(Persona persona) {
        if (usuariosPorId.containsKey(persona.getId())) {
            System.out.println("El usuario ya está registrado.");
            return false;
        }
        usuariosPorId.put(persona.getId(), persona);
        System.out.println("Usuario registrado correctamente.");
        return true;
    }

    // Elimina un usuario si no tiene libros prestados
    public boolean eliminarUsuario(String id) {
        Persona persona = usuariosPorId.get(id);
        if (persona == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }
        if (!persona.getIsbnsPrestados().isEmpty()) {
            System.out.println("El usuario tiene libros prestados y no puede ser eliminado.");
            return false;
        }
        usuariosPorId.remove(id);
        System.out.println("Usuario eliminado correctamente.");
        return true;
    }

    // Presta un libro a un usuario si está disponible
    public boolean prestarLibro(String idUsuario, String isbn) {
        Persona persona = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);

        if (persona == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return false;
        }
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("El libro ya está prestado.");
            return false;
        }

        persona.prestarLibro(isbn);
        isbnsPrestados.add(isbn);
        System.out.println("Libro prestado correctamente.");
        return true;
    }

    // Devuelve un libro prestado por un usuario
    public boolean devolverLibro(String idUsuario, String isbn) {
        Persona persona = usuariosPorId.get(idUsuario);

        if (persona == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }
        if (!isbnsPrestados.contains(isbn)) {
            System.out.println("El libro no está prestado.");
            return false;
        }

        persona.devolverLibro(isbn);
        isbnsPrestados.remove(isbn);
        System.out.println("Libro devuelto correctamente.");
        return true;
    }

    // Búsqueda por título
    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> encontrados = new ArrayList<>();
        for (Libro libro : catalogoPorIsbn.values()) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(libro);
            }
        }
        return encontrados;
    }

    // Búsqueda por autor
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> encontrados = new ArrayList<>();
        for (Libro libro : catalogoPorIsbn.values()) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                encontrados.add(libro);
            }
        }
        return encontrados;
    }

    // Búsqueda por categoría
    public List<Libro> buscarPorCategoria(String categoria) {
        List<Libro> encontrados = new ArrayList<>();
        for (Libro libro : catalogoPorIsbn.values()) {
            if (libro.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                encontrados.add(libro);
            }
        }
        return encontrados;
    }

    // Lista los libros prestados por un usuario
    public List<Libro> listarLibrosPrestados(String idUsuario) {
        Persona persona = usuariosPorId.get(idUsuario);
        List<Libro> librosPrestados = new ArrayList<>();
        if (persona != null) {
            for (String isbn : persona.getIsbnsPrestados()) {
                Libro libro = catalogoPorIsbn.get(isbn);
                if (libro != null) {
                    librosPrestados.add(libro);
                }
            }
        }
        return librosPrestados;
    }
}

