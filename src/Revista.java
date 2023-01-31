
public class Revista extends Material
{
	private String secciones;
	
	public Revista(String titulo, String autor, String secciones)
	{
		super(titulo, autor);
		this.secciones = secciones;
	}

	@Override
	public String toString() {
		return "Revista{" +
				"secciones='" + secciones + '\'' +
				", titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				'}';
	}
}
