public class Estudiante extends Persona
{
    private String matricula;

    public Estudiante(String nombre, String ci, int edad, String matricula) {
        super(nombre, ci, edad);
        this.matricula = matricula;
    }


    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ci='" + ci + '\'' +
                ", edad=" + edad +
                '}';
    }
    
}
