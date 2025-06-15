 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
class Animal {
    String nombre;
    
    void comer() {
        System.out.println(nombre + " come");
    }
}

class Gato extends Animal { // Gato hereda de Animal
    void maullar() {
        System.out.println(nombre + " hace miau");
    }
}

public class Herencia {
    public static void main(String[] args) {
        Gato miGato = new Gato();
        miGato.nombre = "Whiskers";
        miGato.comer();    // Método heredado
        miGato.maullar();  // Método propio
    }
}
