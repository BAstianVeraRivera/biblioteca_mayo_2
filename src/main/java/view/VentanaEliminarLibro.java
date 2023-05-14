package view;
import model.Libro;
import model.data.GestorDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarLibro extends Ventana implements ActionListener {

    private JTextField txtTitulo;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JLabel lblMensaje;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaEliminarLibro(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }

    private void crearComponentes() {
        txtTitulo = new JTextField(20);
        btnEliminar = new JButton("Eliminar");
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEliminar) {
            String titulo = txtTitulo.getText();

            if (titulo.isEmpty()) {
                lblMensaje.setText("Debe ingresar un título.");
                lblMensaje.setForeground(Color.RED);
            }
            else {
                eliminarLibroPorTitulo(titulo);

                JOptionPane.showMessageDialog(this, "Libro eliminado con éxito");
                dispose();
                new VentanaEliminarLibro("Eliminar Libro", 400, 200, gestor);
            }
        }
        else if (e.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Biblioteca", 500, 300, gestor);
        }
    }

    public void eliminarLibroPorTitulo(String titulo) {
        gestor.eliminarLibroPorTitulo(titulo);
    }
}
