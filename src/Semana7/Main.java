/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Clase principal para crear instancias de Vehiculo
public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo();                  // Usando constructor por defecto
        Vehiculo v2 = new Vehiculo("Toyota", 2020);    // Usando constructor parametrizado
        Vehiculo v3 = new Vehiculo("Chevrolet");       // Usando constructor sobrecargado

        // Mostramos la información de cada vehículo
        v1.mostrarInfo();
        v2.mostrarInfo();
        v3.mostrarInfo();
    }
}
