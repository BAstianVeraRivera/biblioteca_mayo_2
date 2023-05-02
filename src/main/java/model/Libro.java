package model;

public class Libro {
	private String titulo;
	private String autor;
	private String fecha;
	private String genero;
	public Biblioteca unnamed_Biblioteca_;

	public Libro(String titulo, String autor, String fecha, String genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.genero = genero;
	}
	public String toString(){
		return "\n Título: "+this.titulo+"\n Autor: "+this.autor+"\n Fecha de publicación: "+this.fecha+"\n Genero: "+this.genero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}