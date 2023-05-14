package model.data;
import model.Libro;
import java.io.*;

public class GestorDatos {
    private String archivoLibros;
    private String archivoLibrosPrestados;

    public String getArchivoLibrosPrestados() {
        return archivoLibrosPrestados;
    }

    public void setArchivoLibrosPrestados(String archivoLibrosPrestados) {
        this.archivoLibrosPrestados = archivoLibrosPrestados;
    }

    public String getArchivoLibros() {
        return archivoLibros;
    }

    public void setArchivoLibros(String archivoLibros) {
        this.archivoLibros = archivoLibros;
    }

    public GestorDatos(String archivoLibros, String archivoLibrosPrestados) {
        this.archivoLibros = archivoLibros;
        this.archivoLibrosPrestados=archivoLibrosPrestados;
    }
    
    public void registrarLibro(Libro libro) {
        try {
            FileWriter fw = new FileWriter(archivoLibros, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getFecha() + "," + libro.getGenero());
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Libro buscarLibroPorTitulo(String nombre) {
        try {
            FileReader fr = new FileReader(archivoLibros);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(nombre )) {
                    br.close();
                    fr.close();
                    return new Libro(datos[0], datos[1], datos[2], datos[3]);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void eliminarLibroPorTitulo(String nombre) {
        try {
            File archivoTemp = new File("librosNoEliminados.txt");
            FileWriter fw = new FileWriter(archivoTemp);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("Libros.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!datos[0].equals(nombre)) {
                    pw.println(linea);
                }
            }
            pw.close();
            bw.close();
            fw.close();
            br.close();
            fr.close();

            File archivoLibros = new File("Libros.txt");
            archivoLibros.delete();
            archivoTemp.renameTo(archivoLibros);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void prestarLibroPorTitulo(String nombre) {
        try {
            File archivoTemp = new File("librosNoPrestados.txt");
            FileWriter fw = new FileWriter(archivoTemp);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader("Libros.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!datos[0].equals(nombre)) {
                    pw.println(linea);
                } else {
                    FileWriter fw2 = new FileWriter("LibrosPrestados.txt", true);
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    PrintWriter pw2 = new PrintWriter(bw2);
                    pw2.println(linea);
                    pw2.close();
                    bw2.close();
                    fw2.close();
                }
            }
            pw.close();
            bw.close();
            fw.close();
            br.close();
            fr.close();
            File archivoLibros = new File("Libros.txt");
            archivoLibros.delete();
            archivoTemp.renameTo(archivoLibros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void devolverLibroPorTitulo(String nombre) {
        try {
            File archivoTemp = new File("librosPrestadosNoDevueltos.txt");
            FileWriter fw = new FileWriter(archivoTemp);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader("LibrosPrestados.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!datos[0].equals(nombre)) {
                    pw.println(linea);
                } else {
                    FileWriter fw2 = new FileWriter("Libros.txt", true); // true para append
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    PrintWriter pw2 = new PrintWriter(bw2);
                    pw2.println(linea);
                    pw2.close();
                    bw2.close();
                    fw2.close();
                }
            }
            pw.close();
            bw.close();
            fw.close();
            br.close();
            fr.close();
            File archivoLibrosPrestados = new File("LibrosPrestados.txt");
            archivoLibrosPrestados.delete();
            archivoTemp.renameTo(archivoLibrosPrestados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
