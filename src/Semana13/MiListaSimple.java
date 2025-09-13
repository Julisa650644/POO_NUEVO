/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana13;

/**
 *
 * @author User
 */

// Importo todo lo necesario para crear la interfaz gráfica
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiListaSimple extends JFrame { // Creo una clase que extiende JFrame para hacer una ventana
    // Aquí declaro los componentes que voy a usar
    private JTextField campoTexto;
    private JButton botonAgregar;
    private JButton botonLimpiar;
    private DefaultListModel<String> modeloLista;
    private JList<String> lista;

    public MiListaSimple() {
        // Le pongo un título a la ventana principal
        setTitle("Mi Lista Simple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 280);
        setLocationRelativeTo(null); // Centro la ventana

        // Uso un layout sencillo para organizar los componentes
        setLayout(new FlowLayout());

        // Creo una etiqueta para indicar al usuario qué hacer
        JLabel etiqueta = new JLabel("Escribe algo:");
        add(etiqueta);

        // Creo el campo de texto donde el usuario va a escribir
        campoTexto = new JTextField(15);
        add(campoTexto);

        // Creo el botón para agregar elementos a la lista
        botonAgregar = new JButton("Agregar");
        add(botonAgregar);

        // Creo el botón para limpiar la lista y el campo de texto
        botonLimpiar = new JButton("Limpiar");
        add(botonLimpiar);

        // Creo el modelo de la lista y la lista en sí
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(250, 100)); // Defino el tamaño preferido del scroll
        add(scroll);// Agrego el scroll  a la ventana

        // Aquí manejo el evento de cuando el usuario hace clic en "Agregar"
        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Tomo el texto del campo y lo limpio de espacios
                String texto = campoTexto.getText().trim();
                // Si el texto no está vacío, lo agrego a la lista
                if (!texto.isEmpty()) {
                    modeloLista.addElement(texto);
                    campoTexto.setText(""); // Limpio el campo de texto
                } else {
                    // Si está vacío, muestro un mensaje de advertencia
                    JOptionPane.showMessageDialog(MiListaSimple.this,
                        "No puedes agregar un texto vacío.");
                }
            }
        });

        // Aquí manejo el evento de cuando el usuario hace clic en "Limpiar"
        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // Defino qué hacer cuando se presiona el botón
                campoTexto.setText(""); // Limpio el campo de texto
                modeloLista.clear();    // Limpio toda la lista
            }
        });
    }

    public static void main(String[] args) { // Método principal para ejecutar el programa
        // Aquí hago visible la ventana principal
        new MiListaSimple().setVisible(true);
    }
}
