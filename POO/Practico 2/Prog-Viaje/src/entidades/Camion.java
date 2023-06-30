package entidades;

public class Camion extends Vehiculo {

    public Camion() {
    }

    public Camion(String marca, String patente, String combustible) {
        super(marca, patente, combustible);
    }
    

    @Override
    public double calcularCostoDeCombustible(double d) {
       return d*12/100;
    }

    @Override
    public double costoPeaje() {
       return 400;
    }
}
