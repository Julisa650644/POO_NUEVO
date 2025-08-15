/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana9;

/**
 *
 * @author User
 */
public class ArchivoVacioException extends Exception {  // Creo una clase que extiende de Exception para definir una excepción personalizada llamada ArchivoVacioException.
    
    /**
     * Constructor por defecto con mensaje predeterminado
     */
    public ArchivoVacioException() { // Defino un constructor sin parámetros.
        super("El archivo está vacío.");
    }
    
    
    public ArchivoVacioException(String mensaje) { // Defino un constructor que recibe un mensaje personalizado.
        super(mensaje);
    }
    
    
    public ArchivoVacioException(String mensaje, Throwable causa) { // Defino un constructor que recibe un mensaje y una causa (otra excepción).
        super(mensaje, causa);
    }
}