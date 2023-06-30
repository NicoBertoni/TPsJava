package entidades;

public class Auto extends Vehiculo {

    public Auto() {
        super();
    }

    public Auto(String marca, String patente, String combustible) {
        super(marca, patente, combustible);
    }
    
    @Override
    public double calcularCostoDeCombustible(double d) {
        double res=d*0.07;
        return res;
    }

    @Override
    public double costoPeaje() {
        return 200;
    }
}
