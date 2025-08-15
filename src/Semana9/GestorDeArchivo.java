/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana9;

/**
 *
 * @author User
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar operaciones de archivos
 * Permite guardar y leer archivos de texto
 */
public class GestorDeArchivo {
    
    /**
     * Método para guardar contenido en un archivo de texto
     * @param nombreArchivo Nombre del archivo a crear/escribir
     * @param contenido Contenido a escribir en el archivo
     */
    public void guardar(String nombreArchivo, String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            bufferedWriter.write(contenido);
            System.out.println("Archivo '" + nombreArchivo + "' guardado exitosamente.");
            
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Método para leer el contenido de un archivo línea por línea
     * @param nombreArchivo Nombre del archivo a leer
     * @return Lista de strings con cada línea del archivo
     */
    public List<String> leer(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        
        try (FileReader reader = new FileReader(nombreArchivo);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                lineas.add(linea);
            }
            
            System.out.println("Archivo '" + nombreArchivo + "' leído exitosamente.");
            
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return lineas;
    }
}