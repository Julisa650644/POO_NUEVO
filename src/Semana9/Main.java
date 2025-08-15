/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana9;

/**
 *
 * @author User
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase principal que demuestra el uso del sistema de gestión de archivos
 * Incluye ejemplos de escritura, lectura y validación de archivos
 */
public class Main {
    public static void main(String[] args) {
        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();
        
        String nombreArchivo = "ejemplo.txt";
        String nombreArchivoVacio = "archivoVacio.txt";
        
        System.out.println("=== SISTEMA DE GESTION DE ARCHIVOS ===\n");
        
        // Caso 1: Crear y escribir contenido en un archivo
        System.out.println("1. Guardando contenido en el archivo...");
        String contenido = "Esta es la primera linea del archivo.\n" +
                          "Esta es la segunda linea.\n" +
                          "Y esta es la tercera linea con más contenido.";
        
        try {
            gestor.guardar(nombreArchivo, contenido);
        } catch (Exception e) {
            System.err.println("Error inesperado al guardar: " + e.getMessage());
        }
        
        System.out.println();
        
        // Caso 2: Leer el contenido del archivo
        System.out.println("2. Leyendo contenido del archivo...");
        try {
            List<String> lineasLeidas = gestor.leer(nombreArchivo);
            System.out.println("Contenido leIdo:");
            for (int i = 0; i < lineasLeidas.size(); i++) {
                System.out.println("Linea " + (i + 1) + ": " + lineasLeidas.get(i));
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al leer: " + e.getMessage());
        }
        
        System.out.println();
        
        // Caso 3: Verificar que el archivo no está vacío
        System.out.println("3. Verificando que el archivo no esté vacío...");
        try {
            validador.verificarNoVacio(nombreArchivo);
        } catch (ArchivoVacioException e) {
            System.err.println("Archivo vacío detectado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de acceso al archivo: " + e.getMessage());
        }
        
        System.out.println();
        
        // Caso 4: Crear un archivo vacío y probar la excepción
        System.out.println("4. Probando con un archivo vacío...");
        try {
            gestor.guardar(nombreArchivoVacio, ""); // Archivo vacío
            validador.verificarNoVacio(nombreArchivoVacio);
        } catch (ArchivoVacioException e) {
            System.err.println("Excepcion capturada correctamente: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de acceso al archivo: " + e.getMessage());
        }
        
        System.out.println();
        
        // Caso 5: Intentar leer un archivo que no existe
        System.out.println("5. Probando con un archivo inexistente...");
        try {
            validador.verificarNoVacio("archivoInexistente.txt");
        } catch (ArchivoVacioException e) {
            System.err.println("Archivo vacío: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de acceso (esperado): " + e.getMessage());
        }
        
        System.out.println();
        
        // Caso 6: Leer archivo que no existe
        System.out.println("6. Intentando leer archivo inexistente...");
        try {
            List<String> resultado = gestor.leer("noExiste.txt");
            System.out.println("Lineas encontradas: " + resultado.size());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
        
        // Limpiar archivos de prueba (opcional)
        try {
            Files.deleteIfExists(Paths.get(nombreArchivo));
            Files.deleteIfExists(Paths.get(nombreArchivoVacio));
            System.out.println("Archivos de prueba eliminados.");
        } catch (IOException e) {
            System.err.println("No se pudieron eliminar los archivos de prueba: " + e.getMessage());
        }
    }
}