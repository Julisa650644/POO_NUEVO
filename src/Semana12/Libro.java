/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */
public class Libro { // Se define la clase Libro.

    private final String isbn;       // Campo que almacena el código ISBN del libro.
    private final String titulo;     // Campo que almacena el título del libro.
    private final String autor;      // Campo que almacena el nombre del autor del libro.
    private final String categoria;  // Campo que indica la categoría o temática del libro.

    // Constructor de la clase Libro
    public Libro(String isbn, String titulo, String autor, String categoria) {
        // Se asignan los valores recibidos a los atributos correspondientes
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Métodos de acceso (getters) para obtener los datos del libro

    public String getIsbn() { return isbn; }           
    public String getTitulo() { return titulo; }       
    public String getAutor() { return autor; }         
    public String getCategoria() { return categoria; } 
    // Método sobrescrito para representar el libro como una cadena de texto
    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + isbn + '\'' +
                ", Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Categoria='" + categoria + '\'' +
                '}';
    }
    
}