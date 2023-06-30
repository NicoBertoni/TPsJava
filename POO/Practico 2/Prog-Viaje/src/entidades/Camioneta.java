package entidades;

public class Camioneta extends Vehiculo {

    public Camioneta() {
    }

    public Camioneta(String marca, String patente, String combustible) {
        super(marca, patente, combustible);
    }
    
    @Override
    public double calcularCostoDeCombustible(double d) {
       return d*10/100;
    }

    @Override
    public double costoPeaje() {
        return 300;
    }
}
