package view;
import model.Libro;
import model.data.GestorDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaAgregarLibro extends Ventana implements ActionListener {
    private JLabel lblTitulo, lblAutor, lblFecha, lblGenero;
    private JTextField txtTitulo, txtAutor, txtFecha, txtGenero;
    private JButton btnRegistrar, btnCancelar;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaAgregarLibro(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }
    private void crearComponentes() {
        lblAutor = new JLabel("Autor:");
        lblTitulo= new JLabel("Título:");
        lblFecha = new JLabel("Fecha de lanzamiento:");
        lblGenero = new JLabel("Género:");
        txtTitulo = new JTextField(15);
        txtAutor = new JTextField(15);
        txtFecha = new JTextField(15);
        txtGenero = new JTextField(15);
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }
    private void agregarComponentes() {
        panel.add(lblTitulo);
        panel.add(txtTitulo);
        panel.add(lblAutor);
        panel.add(txtAutor);
        panel.add(lblFecha);
        panel.add(txtFecha);
        panel.add(lblGenero);
        panel.add(txtGenero);
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
            String autor = txtAutor.getText();
            String fecha = txtFecha.getText();
            String genero = txtGenero.getText();
            Libro libro = new Libro(titulo, autor, fecha, genero);
            gestor.registrarLibro(libro);
            JOptionPane.showMessageDialog(this, "Libro registrado con éxito");
            dispose();
            new VentanaAgregarLibro("Registrar libro",400,200,gestor);
        } else if (accion.getSource() == btnCancelar) {
            dispose();
            new VentanaBienvenida("Biblioteca", 500, 300, gestor);
        }
    }
}