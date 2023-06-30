package entidades;

public class Ciudad {

    private int ruta;

    private int km;

    private String nombre;

    public Ciudad() {
    }

    public Ciudad(int ruta, int km, String nombre) {
        this.ruta = ruta;
        this.km = km;
        this.nombre = nombre;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
