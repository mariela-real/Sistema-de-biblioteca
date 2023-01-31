
public class Libro extends Material
{
	private String editorial;
	
	public Libro(String titulo, String autor, String editorial)
	{
		super(titulo, autor);
		this.editorial = editorial;

	}

	@Override
	public String toString() {
		return "Libro{" +
				"editorial='" + editorial + '\'' +
				", titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				'}';
	}
}
