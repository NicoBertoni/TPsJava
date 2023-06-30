
import java.time.LocalDate;

public class Jubilado extends Persona implements Activo {

    public void cobrar() {
        System.out.println("Cobrando como jubilado ");
        
    }

    public Jubilado(String nombre, long dni, LocalDate fechaNac, String domicilio) {
        super(nombre, dni, fechaNac, domicilio);
    }
    
    @Override
    public void hacerAportes() {
     
    }
}
