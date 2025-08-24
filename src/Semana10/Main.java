/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana10;

/**
 *
 * @author User
 */


import java.util.Scanner;

// Clase principal que contiene el método main
public class Main {

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {

        // Creo una instancia del inventario, que carga los datos desde el archivo
        Inventario inventario = new Inventario();

        // Creo un objeto Scanner para leer entradas del usuario
        Scanner sc = new Scanner(System.in);

        // Variable para almacenar la opción seleccionada por el usuario
        int opcion;

        // Bucle que muestra el menú hasta que el usuario elija salir
        do {
            // Muestra el menú de opciones
            System.out.println("\n MENU DE INVENTARIO");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar cantidad");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            // Lee la opción seleccionada
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer para evitar errores al leer cadenas

            // Ejecuto la acción correspondiente según la opción elegida
            switch (opcion) {
                case 1:
                    // Solicita los datos del nuevo producto
                    System.out.print("Codigo: ");
                    String cod = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();

                    // Agrega el producto al inventario
                    inventario.agregarProducto(new Producto(cod, nom, cant));
                    break;

                case 2:
                    // Solicita el código del producto a actualizar
                    System.out.print("Codigo del producto: ");
                    String codAct = sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCant = sc.nextInt();

                    // Actualiza la cantidad del producto
                    inventario.actualizarCantidad(codAct, nuevaCant);
                    break;

                case 3:
                    // Solicita el código del producto a eliminar
                    System.out.print("Codigo del producto a eliminar: ");
                    String codDel = sc.nextLine();

                    // Elimina el producto del inventario
                    inventario.eliminarProducto(codDel);
                    break;

                case 4:
                    // Muestra todos los productos del inventario
                    inventario.mostrarInventario();
                    break;

                case 0:
                    // Mensaje de salida del sistema
                    System.out.println(" Saliendo del sistema...");
                    break;

                default:
                    // Mensaje si la opción ingresada no es válida
                    System.out.println("Opción inválida.");
            }

        // El bucle se repite mientras la opción no sea 0 (salir)
        } while (opcion != 0);
    }
}