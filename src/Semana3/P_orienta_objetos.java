/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana3; 

import java.util.Scanner; 

/**
 *
 * @author User
 */

// Creo mi clase que representa la información diaria del clima
class ClimaDelDia {
    private double temperatura; // Declaro mi atributo privado para la temperatura
    
    // Creo mi método para ingresar la temperatura
    public void ingresarTemperatura(Scanner s, int dia) {
        System.out.print("Dia " + dia + ": "); // Muestro el mensaje para pedir la temperatura
        temperatura = s.nextDouble(); // Leo y guardo la temperatura en mi atributo
    }
    
    // Creo mi método para obtener la temperatura
    public double obtenerTemperatura() {
        return temperatura; // Retorno el valor de mi temperatura
    }
}

// Creo mi clase principal
public class P_orienta_objetos {
    
    public static void main(String[] args) { // Defino el método main 
        Scanner s = new Scanner(System.in); 
        ClimaDelDia[] semana = new ClimaDelDia[7]; // Creo un array de 7 objetos ClimaDelDia
        
       
        for (int i = 0; i < 7; i++) { // Inicio un ciclo para crear cada objeto
            semana[i] = new ClimaDelDia(); // Creo un nuevo objeto ClimaDelDia
        } 
        
        // Ingreso las temperaturas usando los métodos de mis objetos
        for (int i = 0; i < 7; i++) { // Inicio un ciclo para ingresar temperaturas
            semana[i].ingresarTemperatura(s, i+1); // Llamo al método de cada objeto para ingresar su temperatura
        } 
        
        // Calculo el promedio usando los métodos de mis objetos
        double suma = 0; // Creo una variable para acumular la suma
        for (int i = 0; i < 7; i++) { // Inicio un ciclo para sumar temperaturas
            suma += semana[i].obtenerTemperatura(); // Llamo al método de cada objeto para obtener su temperatura y la sumo
        } 
        
        double promedio = suma / 7; // Calculo el promedio dividiendo la suma entre 7
        
        System.out.println("Promedio semanal: " + promedio + "°C"); // Muestro el resultado
        
        s.close();
    } 
} 
