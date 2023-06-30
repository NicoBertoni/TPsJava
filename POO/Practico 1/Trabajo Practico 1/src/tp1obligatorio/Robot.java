
package tp1obligatorio;


public class Robot {
    private int pasos;
    private boolean dormido;
    private final Bateria bateria;
    private int restarEnergia;

    private final int MAX_BATTERY = 1000;

    public Robot() {
        this.pasos = 0;
        this.dormido = false;
        this.bateria = new Bateria(MAX_BATTERY);
        this.restarEnergia = 0;
    }

    // Tanto avanzar como retroceder se podrian  resumir en un mismo metodo
    // ya que no se esta evaluando o teniendo en cuenta la posicion del robot,
    // solo se hace la logica para descontar bateria a los 100 pasos (sea avanzando o retrocediendo)


    public void avanzar(int cantidadPasos) {
        if (!dormido && energiaActual() > 0) {
            this.pasos += cantidadPasos;
            if (this.pasos >= 10) {
                this.restarEnergia=(cantidadPasos/10);
                this.bateria.setCarga(energiaActual()-restarEnergia);
                this.pasos = 0;
            }
        } else {
            System.out.println("El robot no va a avanzar por que esta dormido y/o le falta energia");
        }
    }

    public void retroceder(int cantidadPasos) {
        if (!dormido && energiaActual() > 0) {
            this.pasos += cantidadPasos;
            if (this.pasos >= 10) {
                this.restarEnergia=(cantidadPasos/10);
                this.bateria.setCarga(energiaActual()-restarEnergia);
                this.pasos = 0;
            }
        } else {
            System.out.println("El robot no va a retroceder por que esta dormido  y/o le falta energia");
        }
    }

    // Los metodos dormir y despertar tambien se podrian simplificar en uno usandolo como switch ON/OFF
    // this.dormido = !this.dormido

    public void dormir() {
        this.dormido = true;
        System.out.println("El robot esta dormido");
    }

    public void despertar() {
        this.dormido = false;
        System.out.println("El robot esta despierto");
    }

    public void recargar() {
        this.bateria.setCarga(MAX_BATTERY);
        System.out.println("Se le ha llenado la bateria al robot");
    }

    public boolean bateriaLLena() {
        return this.bateria.getCarga() == MAX_BATTERY;
    }

    public boolean bateriaVacia() {
        return this.bateria.getCarga() == 0;
    }

    public int energiaActual() {
        return bateria.getCarga();
    }
}
