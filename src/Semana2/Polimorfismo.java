/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana2;

/**
 *
 * @author User
 */
class Animal {
    void sonido() {
        System.out.println("Sonido de animal");
    }
}

class Perro extends Animal {
    void sonido() {
        System.out.println("Guau");
    }
}

class Gato extends Animal {
    void sonido() {
        System.out.println("Miau");
    }
}

public class Polimorfismo {
    public static void main(String[] args) {
        
        Animal perro = new Perro();
        Animal gato = new Gato();
        
        perro.sonido(); // Guau
        gato.sonido();  // Miau
        
        // ESO ES POLIMORFISMO: mismo método, diferentes resultados
    }
}
