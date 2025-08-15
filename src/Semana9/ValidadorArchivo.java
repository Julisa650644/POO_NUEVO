/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana9;
import java.io.*;
/**
 *
 * @author User
 */
public class ValidadorArchivo {
   
    public void verificarNoVacio(String nombreArchivo) throws ArchivoVacioException, IOException {
        // Abro el archivo usando FileReader y lo envuelvo en un BufferedReader para leerlo línea por línea
        try (FileReader reader = new FileReader(nombreArchivo);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            // Leo la primera línea del archivo
            String primeraLinea = bufferedReader.readLine();

            // Si la primera línea es null, significa que el archivo está completamente vacío
            if (primeraLinea == null) {
                // Lanzo una excepción personalizada indicando que el archivo está vacío
                throw new ArchivoVacioException("El archivo '" + nombreArchivo + "' está vacío.");
            }

            // Si la primera línea existe pero está vacía (solo espacios), verifico si hay más contenido
            if (primeraLinea.trim().isEmpty()) {
                // Leo la segunda línea para ver si hay algo más en el archivo
                String segundaLinea = bufferedReader.readLine();

                // Si no hay segunda línea, el archivo solo contiene líneas vacías
                if (segundaLinea == null) {
                    // Lanzo una excepción indicando que el archivo no tiene contenido útil
                    throw new ArchivoVacioException("El archivo '" + nombreArchivo + "' solo contiene líneas vacías.");
                }
            }

            // Si llego aquí, el archivo tiene contenido válido, así que lo informo por consola
            System.out.println("El archivo '" + nombreArchivo + "' contiene datos válidos.");

        } catch (FileNotFoundException e) {
            // Si el archivo no se encuentra, lanzo una IOException con un mensaje más claro
            throw new IOException("Archivo no encontrado: " + nombreArchivo, e);
        }
    } 
}
