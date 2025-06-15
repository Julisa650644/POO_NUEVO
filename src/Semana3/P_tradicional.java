/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author User
 */
public class P_tradicional {
    
    public static void main(String[] args) { // Defino el método main donde inicia mi programa
        double[] temperaturas = new double[7]; // Creo un array para almacenar 7 temperaturas
         
        ingresarTemperaturas(temperaturas);
        double promedio = calcularPromedio(temperaturas); // Llamo a mi función para calcular el promedio y lo guardo
        
        System.out.println("Promedio semanal: " + promedio + "°C");
    }
    
    // Función para ingresar temperaturas
    public static void ingresarTemperaturas(double[] temp) {
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < 7; i++) { // Inicio un ciclo que se repetirá 7 veces (una por cada día)
            System.out.print("Dia " + (i+1) + ": ");
            temp[i] = s.nextDouble(); // Leo la temperatura del usuario y la guardo en mi array
        }
    }
    
    // Función para calcular promedio
    public static double calcularPromedio(double[] temp) {
        double suma = 0; // Creo una variable para acumular la suma de temperaturas
        for (int i = 0; i < 7; i++) { // Inicio un ciclo para recorrer todas las temperaturas
            suma += temp[i]; // Sumo cada temperatura a mi variable suma
        }
        return suma / 7;
    }
}