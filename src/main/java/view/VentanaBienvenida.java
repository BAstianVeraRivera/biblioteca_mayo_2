package view;
import model.data.GestorDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaBienvenida extends Ventana implements ActionListener {
    private JButton btnRegistrarLibro, btnEliminarLibro,btnBuscarLibro, btnPrestarLibro, btnDevolverLibro, btnSalir;
    private JPanel panel;
    private GestorDatos gestor;

    public VentanaBienvenida(String titulo, int ancho, int alto, GestorDatos gestor) {
        super(titulo, ancho, alto);
        this.gestor = gestor;
        crearComponentes();
        agregarComponentes();
        agregarEventos();
        setVisible(true);
    }


    private void crearComponentes() {
        btnRegistrarLibro = new JButton("Registrar libro");
        btnEliminarLibro = new JButton("Eliminar libro");
        btnBuscarLibro = new JButton("Buscar libro");
        btnPrestarLibro = new JButton("Prestar libro");
        btnDevolverLibro = new JButton("Devolver libro");
        btnSalir = new JButton("Salir");
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
    }

    private void agregarComponentes() {
        panel.add(btnRegistrarLibro);
        panel.add(btnEliminarLibro);
        panel.add(btnBuscarLibro);
        panel.add(btnPrestarLibro);
        panel.add(btnDevolverLibro);
        panel.add(btnSalir);

        add(panel);
    }

    private void agregarEventos() {
        btnRegistrarLibro.addActionListener(this);
        btnEliminarLibro.addActionListener(this);
        btnBuscarLibro.addActionListener(this);
        btnPrestarLibro.addActionListener(this);
        btnDevolverLibro.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == btnRegistrarLibro) {
            dispose();
            new VentanaAgregarLibro("Registrar libro", 400, 200, gestor);
        } else if (accion.getSource() == btnEliminarLibro) {
            dispose();
            new VentanaEliminarLibro("Eliminar Libro", 400, 200, gestor);
        } else if (accion.getSource() == btnBuscarLibro) {
            dispose();
            new VentanaBuscarLibro("Buscar Libro", 400, 200, gestor);
        } else if (accion.getSource() == btnPrestarLibro) {
            dispose();
            new VentanaPrestarLibro("Prestar Libro", 400, 150, gestor);
        }else if (accion.getSource() == btnDevolverLibro) {
            dispose();
            new VentanaDevolverLibro("Devolver libro", 400, 150, gestor);
        }else if (accion.getSource() == btnSalir) {
            System.exit(0);
        }
    }
}