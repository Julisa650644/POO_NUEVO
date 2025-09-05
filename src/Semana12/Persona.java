/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persona {  // Se define la clase Persona, que representa a un individuo que puede tener libros prestados.
    private final String id;
    private final String nombre;
    private final List<String> isbnsPrestados; // Lista de ISBNs de libros que la persona tiene prestados.

    // Constructor de la clase Persona
    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }
    
    // Métodos de acceso (getters)

    public String getId() { return id; }  // Devuelve el ID de la persona.
    public String getNombre() { return nombre; }
    public List<String> getIsbnsPrestados() { return Collections.unmodifiableList(isbnsPrestados); }

    // Devuelve una versión no modificable de la lista de libros prestados.
   
    // Método para registrar el préstamo de un libro
    public void prestarLibro(String isbn) {
        isbnsPrestados.add(isbn);
    }
// Método para registrar la devolución de un libro
    public void devolverLibro(String isbn) {
        isbnsPrestados.remove(isbn);
    }

    
    // Método sobrescrito para representar la persona como una cadena de texto
    @Override
    public String toString() {
        return "Persona{" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Libros prestados=" + isbnsPrestados +
                '}';
    }
}
