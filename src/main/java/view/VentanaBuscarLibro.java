package view;
import model.Libro;
import model.data.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaBuscarLibro extends Ventana implements ActionListener {
    private JTextField txtTitulo;
    private JLabel lblTitulo;
    private JButton btnBuscar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaBuscarLibro(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        lblTitulo = new JLabel("Nombre:");
        txtTitulo = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }

    private void agregarComponentes() {
        panel.add(lblTitulo);
        panel.add(txtTitulo);
        panel.add(btnBuscar);
        panel.add(btnCancelar);
        add(panel);
    }

    private void agregarEventos() {
        btnBuscar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnBuscar) {
            String nombre = txtTitulo.getText();
            Libro libro = gestor.buscarLibroPorTitulo(nombre);
            if (libro != null) {
                JOptionPane.showMessageDialog(this, "Libro encontrado: " +libro.toString());
                dispose();
                new VentanaBuscarLibro("Buscar Libro", 400, 200, gestor);
            } else {
                JOptionPane.showMessageDialog(this, "Libro no hallado");
                dispose();
                new VentanaBuscarLibro("Buscar Libro", 400, 200, gestor);
            }
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Biblioteca", 500, 300, gestor);
        }
    }
}