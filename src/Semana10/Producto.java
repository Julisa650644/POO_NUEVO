/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana10;

/**
 *
 * @author User
 */
// Defino una clase pública llamada Producto
public class Producto {

    // Declaro tres atributos privados: código, nombre y cantidad
    private String codigo;
    private String nombre;
    private int cantidad;

    // Constructor que inicializa los atributos con los valores recibidos
    public Producto(String codigo, String nombre, int cantidad) {
        this.codigo = codigo;       
        this.nombre = nombre;       
        this.cantidad = cantidad;   
    }

    // Método público que devuelve el código del producto
    public String getCodigo() { return codigo; }

    // Método público que devuelve el nombre del producto
    public String getNombre() { return nombre; }

    // Método público que devuelve la cantidad del producto
    public int getCantidad() { return cantidad; }

    // Método público que permite modificar la cantidad del producto
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    
    @Override
    public String toString() {
        // Devuelvo una cadena con los atributos separados por comas
        return codigo + "," + nombre + "," + cantidad;
    }

    // Método estático que crea un objeto Producto a partir de una cadena de texto
    public static Producto fromString(String linea) {
        // Divide la cadena en partes usando la coma como separador
        String[] partes = linea.split(",");
        // Crea y devuelve un nuevo objeto Producto usando las partes extraídas
        return new Producto(partes[0], partes[1], Integer.parseInt(partes[2]));
    }
}
