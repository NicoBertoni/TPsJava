package entidades;

import java.text.DecimalFormat;

public class Viaje {

    private Ciudad origen;

    private Ciudad destino;

    private double distancia;

    private Vehiculo v;

    private int peajes;
    private double costo;

    public Viaje(Ciudad origen, Ciudad destino, double distancia, Vehiculo v, int peajes) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        
        this.v = v;
        this.peajes = peajes;
    }

    public Viaje(Ciudad origen, Ciudad destino, Vehiculo v, int peajes) {
        this.origen = origen;
        this.destino = destino;
        this.v = v;
        this.peajes = peajes;
        this.costo = costo;
        this.distancia= Math.abs(origen.getKm()-destino.getKm());
    }
    

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vehiculo getV() {
        return v;
    }

    public void setV(Vehiculo v) {
        this.v = v;
    }

    public int getPeajes() {
        return peajes;
    }

    public void setPeajes(int peajes) {
        this.peajes = peajes;
    }

    public double calculoCostoComb() {
        
        double resultCom= v.calcularCostoDeCombustible(distancia);
        double precCom = resultCom * obtenerPrecio(v.getCombustible());

        return precCom;
    }

    public double calculoCostoPeajes() {
        double precPeaje = peajes * v.costoPeaje();
        return precPeaje;
    }

    public double calcularCosto() {

        return calculoCostoComb()+calculoCostoPeajes();
    }

    private double obtenerPrecio(String c) {

        for (int i = 0; i < v.comb.length; i++) {
            if (c.equalsIgnoreCase(v.comb[i])) {
                return v.precio[i];

            }
        }
        return 0;

    }

}
