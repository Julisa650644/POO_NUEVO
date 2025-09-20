/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana14;

/**
 *
 * @author User
 */
// Importo las clases necesarias para construir la interfaz gráfica con Swing
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*; // Importo clases para gestionar el diseño visual
import java.awt.event.*;
import java.text.SimpleDateFormat; // Importo la clase Date para trabajar con fechas y horas
import java.util.Date;
 // Defino la clase principal que extiende JFrame para crear la ventana de la agenda
public class AgendaSwing extends JFrame {
    // Componentes principales
    private JTable tablaEventos; // Aquí mostraré los eventos registrados
    private DefaultTableModel modeloTabla; // Este modelo me permite manejar los datos de la tabla
    private JSpinner spinnerFecha; // Usaré este componente para seleccionar la fecha del evento
    private JSpinner spinnerHora; // Este componente servirá para elegir la hora del evento
    private JTextField txtDescripcion;
// Constructor de la clase, donde configuro toda la interfaz
    public AgendaSwing() {
        setTitle("Agenda Personal");  // Establezco el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Defino el tamaño de la ventana
        setLocationRelativeTo(null);

        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        setContentPane(panelPrincipal);

        // Panel de entrada de datos 
        JPanel panelEntrada = new JPanel(new GridLayout(2, 4, 5, 5)); // Creo un panel con GridLayout para organizar los campos de entrada
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Nuevo Evento"));  // Le agrego un borde con título

        // Fecha
        panelEntrada.add(new JLabel("Fecha (dd/MM/yyyy):"));
        spinnerFecha = new JSpinner(new SpinnerDateModel()); 
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));
        panelEntrada.add(spinnerFecha);

        // Hora
        panelEntrada.add(new JLabel("Hora (HH:mm):"));
        spinnerHora = new JSpinner(new SpinnerDateModel());
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm"));
        panelEntrada.add(spinnerHora);

        // Descripción
        panelEntrada.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelEntrada.add(txtDescripcion);
// Agrego dos etiquetas vacías 
        panelEntrada.add(new JLabel(""));
        panelEntrada.add(new JLabel(""));

        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);

        //  Panel de la tab
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Hora", "Descripción"}, 0);  // Inicializo el modelo de la tabla con columnas para fecha, hora y descripción
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEventos);  // Creo la tabla con el modelo definid
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Eventos Programados"));
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);

        //  Panel de botones 
        JPanel panelBotones = new JPanel(); // Creo un panel para los botones de acción
        // Inicializo los botones
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar seleccionado");
        JButton btnSalir = new JButton("Salir");
       // Añado los botones al panel
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        //  Acciones de los botones 

        // Agregar evento
        btnAgregar.addActionListener(e -> agregarEvento());

        // Eliminar evento seleccionado
        btnEliminar.addActionListener(e -> eliminarEvento());

        // Salir
        btnSalir.addActionListener(e -> dispose());
    }
// Método para agregar un evento a la tabla
    private void agregarEvento() {
        String descripcion = txtDescripcion.getText().trim(); // Obtengo la descripción del campo de texto
        if (descripcion.isEmpty()) {  // Verifico que no esté vacía
            JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía", "Validación", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
         // Obtengo la fecha y hora seleccionadas
        Date fecha = (Date) spinnerFecha.getValue();
        Date hora = (Date) spinnerHora.getValue();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String strFecha = formatoFecha.format(fecha);
        String strHora = formatoHora.format(hora);

         // Agrego una nueva fila a la tabla con los datos del evento
        modeloTabla.addRow(new Object[]{strFecha, strHora, descripcion});
        txtDescripcion.setText(""); // Limpio el campo de descripción para el siguiente ingreso
        txtDescripcion.requestFocus();
    }

    private void eliminarEvento() {  // Método para eliminar el evento seleccionado
        int filaSeleccionada = tablaEventos.getSelectedRow();
        if (filaSeleccionada == -1) {  // Verifico si hay una fila seleccionada
           // Muestro mensaje si no hay selección
            JOptionPane.showMessageDialog(this, "Selecciona un evento primero", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Confirmo con el usuario si desea eliminar el evento
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar el evento seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
         // Si el usuario confirma, elimino la fila
        if (confirm == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
        }
    }
  // Método principal 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {  // Utilizo invokeLater para asegurar que la interfaz se construya en el hilo de eventos
            new AgendaSwing().setVisible(true); // Creo y muestro la ventana
        });
    }
}