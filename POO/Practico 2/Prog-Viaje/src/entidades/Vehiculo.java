package entidades;

public abstract class Vehiculo {
    protected String[] comb = {"nafta","diesel","gnc"}; 
    protected double[] precio = {163.10,175.1,71.23};
    private String marca;

    private String patente;

    private String combustible;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String patente, String combustible) {
        this.marca = marca;
        this.patente = patente;
        this.combustible = combustible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
    

    public abstract double calcularCostoDeCombustible(double d);

    public abstract double costoPeaje();
}
