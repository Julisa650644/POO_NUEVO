/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana2;

/**
 *
 * @author User
 */
abstract class Animal {
    // Método abstracto 
    public abstract void hacerSonido();
    
    // Método que va a decir que esta respirando
    public void respirar() {
        System.out.println("El animal está respirando.");
    }
}

// Clase concreta que extiende la clase abstracta
class Perro extends Animal {
    // Implementación del método abstracto
    public void hacerSonido() {
        System.out.println("El perro dice: Guau");
    }
}

public class Abstraccion {
    public static void main(String[] args) {
        Animal miPerro = new Perro();
        miPerro.hacerSonido(); 
        miPerro.respirar();    
    }
}
