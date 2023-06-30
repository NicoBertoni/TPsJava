package tp4.lab;

public class TP4Lab {

  public static void main(String[] args) {
        Position position = new Position(100, 200);
        Guerrero guerrero = new Guerrero(position, "Thor");

        while (guerrero.getOrientacion()!= 'o') {
            guerrero.girar();

        }

        //se detiene cuando mira al  oeste 
        for (int i = 0; i < 5; i++) {
            guerrero.avanzar();
            
        }
        for (int i = 0; i < 8; i++) {
            guerrero.disparar();
            
        }

        System.out.println("La energia es: " + guerrero.getEnergia());
        System.out.println("la ubicacion es : " + guerrero.getUbicacion());

    }

}
    
