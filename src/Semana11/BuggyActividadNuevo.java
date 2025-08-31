/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana11;

/**
 *
 * @author User
 */


import java.util.*;

public class BuggyActividadNuevo {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        //  índice válido (0,1,2)
        // Antes se usaba nombres.get(3) que daba error porque la lista tiene solo 3 elementos (índices 0 a 2)
        System.out.println("Elemento en posición 2: " + nombres.get(2));

        // Corrección: comparar cadenas con equals en lugar de ==
        // '==' compara referencias, no contenido. equals compara el contenido de las cadenas.
        String buscado = new String("Ana");
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");

        // Corrección: evitar sobrescribir sin control
        // Se verifica si la clave "Ana" ya existe antes de insertar para no sobrescribir el valor anterior
        if (!telefonos.containsKey("Ana")) {
            telefonos.put("Ana", "0993333333");
        } else {
            System.out.println("La clave 'Ana' ya existe, no se sobrescribe.");
        }

        // Corrección: validar existencia antes de usar el valor para evitar NullPointerException
        String telefonoBea = telefonos.get("Bea");
        if (telefonoBea != null) {
            System.out.println("Bea: " + telefonoBea);
        } else {
            System.out.println("Bea no está en el mapa");
        }

        // SET de inscritos con equals y hashCode corregidos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado lógico detectado y evitado

        // El tamaño será 2 porque el duplicado lógico no se añade gracias a equals y hashCode
        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

class Alumno {
    int id;
    String nombre;

    Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }

    // Sobrescribir equals para comparar contenido lógico (id y nombre)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre);
    }

    // Sobrescribir hashCode para mantener contrato con equals y permitir detección correcta en HashSet
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
    //fin
}