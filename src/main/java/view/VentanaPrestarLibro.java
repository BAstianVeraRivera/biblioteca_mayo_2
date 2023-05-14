package view;
import model.data.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaPrestarLibro extends Ventana implements ActionListener {
    private JTextField txtTitulo;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JLabel lblMensaje;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaPrestarLibro(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        txtTitulo = new JTextField(20);
        btnEliminar = new JButton("Prestar");
        btnCancelar = new JButton("Cancelar");
        lblMensaje = new JLabel("");
    }

    private void agregarComponentes() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(new JLabel("Título del libro:"));
        panel.add(txtTitulo);
        panel.add(btnEliminar);
        panel.add(btnCancelar);
        panel.add(lblMensaje);
        this.add(panel);
    }

    private void agregarEventos() {
        btnEliminar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnEliminar) {
            String titulo = txtTitulo.getText();

            if (titulo.isEmpty()) {
                lblMensaje.setText("Debe ingresar un título.");
                lblMensaje.setForeground(Color.RED);
            }
            else {
                prestarLibroPorTitulo(titulo);
                JOptionPane.showMessageDialog(this, "Se ha prestado el libro "+titulo.toString()+" y se ha quitado del inventario");
                dispose();
                new VentanaPrestarLibro("Prestar libro",400,150,gestor);
            }
        }
        else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Biblioteca", 500, 300, gestor);
        }
    }

    public void prestarLibroPorTitulo(String titulo) {
        gestor.prestarLibroPorTitulo(titulo);
    }
}