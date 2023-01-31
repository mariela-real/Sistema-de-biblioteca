import java.util.*;
class Persona{

    protected String nombre;
    protected String ci;
    protected int edad;
	private boolean esDeudor;

    public Persona(String nombre,String ci,int edad){
        this.nombre=nombre;
        this.edad=edad;
        this.ci=ci;
		this.esDeudor = false;
    }

	public Persona(String nombre)
	{
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", ci=" + ci + ", edad=" + edad + "]";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCi(String ci) {
		this.ci = ci;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setEsDeudor(boolean esDeudor) {
		this.esDeudor = esDeudor;
	}
}