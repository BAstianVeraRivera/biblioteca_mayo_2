package model;
import java.util.ArrayList;
import model.Libro;
public class Biblioteca {
	private String nombreBiblio;
	private String direccion;
	private String horario;
	public ArrayList<Libro> libros = new ArrayList<Libro>();

	public Biblioteca(String nombreBiblio, String direccion, String horario) {
		this.nombreBiblio = nombreBiblio;
		this.direccion = direccion;
		this.horario = horario;
	}

	public String getNombreBiblio() {
		return this.nombreBiblio;
	}

	public void setNombreBiblio(String nombreBiblio) {
		this.nombreBiblio = nombreBiblio;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}