/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana10;

/**
 *
 * @author User
 */
// Importo clases necesarias a
import java.io.*;
import java.util.*;

// Defino la clase pública Inventario
public class Inventario {

    // Creo un mapa para almacenar productos, usando el código como clave
    private Map<String, Producto> productos = new HashMap<>();

    // Defino el nombre del archivo donde se guarda el inventario
    private final String archivo = "inventario.txt";


    public Inventario() {
        cargarDesdeArchivo();
    }

    // Método para agregar un nuevo producto al inventario
    public void agregarProducto(Producto p) {
        productos.put(p.getCodigo(), p);     // Inserto el producto en el mapa usando su código
        guardarEnArchivo();                  // Guardo el inventario actualizado en el archivo
        System.out.println(" Producto agregado: " + p.getNombre()); // Mensaje de confirmación
    }

    // Método para actualizar la cantidad de un producto existente
    public void actualizarCantidad(String codigo, int nuevaCantidad) {
        Producto p = productos.get(codigo);  // Busca el producto por su código
        if (p != null) {
            p.setCantidad(nuevaCantidad);   // Actualiza la cantidad
            guardarEnArchivo();             // Guarda los cambios en el archivo
            System.out.println("Cantidad actualizada para: " + p.getNombre());
        } else {
            System.out.println(" Producto no encontrado."); // Mensaje si no se encuentra el producto
        }
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(String codigo) {
        if (productos.remove(codigo) != null) { // Elimina el producto si existe
            guardarEnArchivo();                 // Guarda el inventario actualizado
            System.out.println("️ Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para mostrar todos los productos del inventario
    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (Producto p : productos.values()) {
            // Muestro el código, nombre y cantidad de cada producto
            System.out.println(p.getCodigo() + " - " + p.getNombre() + " - Cantidad: " + p.getCantidad());
        }
    }

    // Método privado para guardar el inventario en el archivo
    private void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto p : productos.values()) {
                writer.write(p.toString());  // Escribo cada producto como línea de texto
                writer.newLine();            // Inserto salto de línea
            }
        } catch (IOException e) {
            System.out.println(" Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método privado para cargar el inventario desde el archivo
    private void cargarDesdeArchivo() {
        File f = new File(archivo);          // Creo un objeto File para el archivo
        if (!f.exists()) {                   // Verifico si el archivo existe
            System.out.println(" Archivo no encontrado. Se creara uno nuevo.");
            guardarEnArchivo();             // Si no existe, crea uno vacío
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Producto p = Producto.fromString(linea); // Conviertp¿o la línea en un objeto Producto
                productos.put(p.getCodigo(), p);         
            }
            System.out.println(" Inventario cargado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}