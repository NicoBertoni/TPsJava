/*

 */
package tp1obligatorio;


public class Bateria {
    private int carga;

    public Bateria(int cargaInicial) {
        carga = cargaInicial;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int nuevaCarga) {
        carga = nuevaCarga;
    }
}