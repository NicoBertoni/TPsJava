
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public abstract class Persona {

    private String nombre;

    private long dni;

    private LocalDate fechaNac;

    private String domicilio;

    public Persona() {
    }

    public Persona(String nombre, long dni, LocalDate fechaNac, String domicilio) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int calcularEdad() {
       LocalDate h= LocalDate.now();
       return h.compareTo(fechaNac);
    }

    public long calcularDiasVividos() {
       LocalDate h= LocalDate.now();
       //Period p = Period.between(fechaNac,h);
       //return p.getDays();
       long dias = ChronoUnit.DAYS.between(fechaNac,h);
       return dias;
    }

    public abstract void cobrar();
    
}
