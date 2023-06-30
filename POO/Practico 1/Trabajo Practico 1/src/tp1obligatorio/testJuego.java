/*
 */
package tp1obligatorio;

public class testJuego {


    public static void main(String[] args) {
        Robot robot1 = new Robot();
        Hombre h1 = new Hombre("Pedro");
        System.out.println(h1.getNombre()+" esta jugando ahora con el robot");
        h1.jugarConRobot(robot1);
        System.out.println("La bateria actual es de :" +robot1.energiaActual());
        //robot1.despertar();
        //Hombre h2 = new Hombre("Guillermo");
        //System.out.println(h2.getNombre()+" esta jugando ahora con el robot");
        //h2.jugarConRobot(robot1);
        
    }
}
