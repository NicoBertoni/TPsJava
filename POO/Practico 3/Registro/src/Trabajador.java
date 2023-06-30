
import java.time.LocalDate;

public class Trabajador extends Persona implements Activo {

    private double sueldo=0;
    
    public Trabajador() {
    }

    public Trabajador(String nombre, long dni, LocalDate fechaNac, String domicilio,double s) {
        super(nombre, dni, fechaNac, domicilio);
        this.sueldo=s;
    }

    @Override
    public void cobrar() {
        System.out.println("Monto a cobrar: "+this.sueldo);
    }

    @Override
    public void hacerAportes() {
     double aporte = this.sueldo*0.11;
        System.out.println("El sueldo quedo en "+ (this.sueldo-aporte));
    }
}
