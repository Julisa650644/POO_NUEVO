/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana2;

/**
 *
 * @author User
 */
class Persona {
    // Coloco este atributo en privado
    private String nombre;
    
    // Creo este método para que otros puedan PONER un nombre
    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre; // Guardo el nombre aquí
    }
    
    
    public String getNombre() {
        return nombre;
    }
}

public class Encapsulacion {
    public static void main(String[] args) {
        
        Persona yo = new Persona();
        
        // Uso el método público para poner mi nombre
        yo.setNombre("Julissa");
        
     
        System.out.println("Mi nombre es: " + yo.getNombre());
        
        
    }
}
