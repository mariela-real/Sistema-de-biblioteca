import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prestamo
{
    private Persona persona;
    private Material material;


    public Prestamo(Persona persona, Material material) {
        this.persona = persona;
        this.material = material;

    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "persona=" + persona +
                ", material=" + material +
                '}';
    }
}
