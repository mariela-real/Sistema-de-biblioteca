
public class Docente extends Persona 
{
	private String codDocente;
	
	public Docente(String nombre, String ci, int edad , String codDocente)
	{
		super(nombre, ci, edad);
		this.codDocente = codDocente;

	}

	public String getCodDocente() {
		return codDocente;
	}

	@Override
	public String toString() {
		return "Docente{" +
				"codDocente='" + codDocente + '\'' +
				", nombre='" + nombre + '\'' +
				", ci='" + ci + '\'' +
				", edad=" + edad +
				'}';
	}
}
