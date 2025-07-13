/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Declaro una clase llamada Vehiculo
public class Vehiculo {

    // Aquí creo dos variables privadas para guardar la marca y el año del vehículo
    private String marca;
    private int año;

    // Este es el constructor por defecto
    public Vehiculo() {
        // Le doy un valor inicial a la marca
        this.marca = "Desconocida";
        // Le doy un valor inicial al año
        this.año = 0;
        // Imprimo un mensaje para decir que se creó el vehículo sin datos específicos
        System.out.println("Vehiculo creado con valores por defecto.");
    }

    // Este es un constructor con parámetros
    public Vehiculo(String marca, int año) {
        // Guardo la marca que me pasaron
        this.marca = marca;
        // Guardo el año que me pasaron
        this.año = año;
        // Imprimo un mensaje mostrando los datos que se usaron para crear el vehículo
        System.out.println("Vehiculo creado: " + this.marca + ", Año: " + this.año);
    }

    // Este constructor sobrecargado sirve cuando solo me pasan la marca
    public Vehiculo(String marca) {
        // Guardo la marca que me pasaron
        this.marca = marca;
        // Si no me dieron el año, yo le asigno uno por defecto
        this.año = 2024;
        // Imprimo un mensaje mostrando que se creó el vehículo con año por defecto
        System.out.println("Vehiculo creado con marca: " + this.marca + " y año por defecto.");
    }

    // Este es un método para mostrar los datos del vehículo
    public void mostrarInfo() {
        // Imprimo la marca y el año guardados
        System.out.println("Marca: " + this.marca + ", Año: " + this.año);
    }
}



