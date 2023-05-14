package principal;

import model.data.GestorDatos;
import view.VentanaBienvenida;

public class Principal {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos("Libros.txt","LibrosPrestados");
        new VentanaBienvenida("Biblioteca", 500, 300,gestor);
    }
}