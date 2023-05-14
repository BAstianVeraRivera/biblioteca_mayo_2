package view;
import model.Libro;
import model.data.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaDevolverLibro extends Ventana implements ActionListener {
    private JLabel lblTitulo;
    private JTextField txtTitulo;
    private JButton btnRegistrar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaDevolverLibro(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }
    private void crearComponentes() {
        lblTitulo= new JLabel("Título:");
        txtTitulo = new JTextField(15);
        btnRegistrar = new JButton("Devolver");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
    }
    private void agregarComponentes() {
        panel.add(lblTitulo);
        panel.add(txtTitulo);
        panel.add(btnRegistrar);
        panel.add(btnCancelar);

        add(panel);
    }
    private void agregarEventos() {
        btnRegistrar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnRegistrar) {
            String titulo = txtTitulo.getText();
            devolverLibroPorTitulo(titulo);
            JOptionPane.showMessageDialog(this, "El libro "+titulo.toString()+" ha sido reingresado al inventario");
            dispose();
            new VentanaDevolverLibro("Devolver Libro", 400, 150, gestor);
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Biblioteca", 500, 300, gestor);
        }
    }
    public void devolverLibroPorTitulo(String titulo) {
        gestor.devolverLibroPorTitulo(titulo);
    }
}
