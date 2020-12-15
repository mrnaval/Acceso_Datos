package parse_libro;

import java.io.Serializable;

public class Libro implements Serializable{

	private String titulo = null;
	private int anyo = 0;
	private String nombre = null;
	private String apellido = null;
	private String editor = null;
	private int paginas = 0;
	
	public Libro() {
		
	}

	public Libro(String t, int an, String n, String a, String e, int p) {
		titulo = t;
		anyo = an;
		nombre = n;
		apellido = a;
		editor = e;
		paginas = p;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	
	public void print() {
		System.out.println("Libro: " +titulo+ " | Año: " +anyo+ " | Autor: " +nombre+ " " +apellido+ " | Editor: " +editor+ " | Páginas: " +paginas);
	}
	
	
}
