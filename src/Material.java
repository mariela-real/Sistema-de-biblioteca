
public class Material
{
	protected String titulo;
	protected String autor;

	public Material(String titulo, String autor) {

		this.titulo = titulo;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Material [titulo=" + titulo + ", autor=" + autor +"]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
