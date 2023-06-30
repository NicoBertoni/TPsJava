package tp1obligatorio;

import java.util.Scanner;

public class Hombre {

    private String nombre;

    public Hombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

public void jugarConRobot(Robot robot1) {
        Scanner scanner = new Scanner(System.in);
        String res="No";
while (res.equalsIgnoreCase("No")){
        System.out.println("Que accion desea realizar? (avanzar o retroceder)");
        String accion = scanner.next();
        
        System.out.println("Cantidad de pasos que desea realizar? ");
        int cantidadPasos = scanner.nextInt();
        if(accion.equalsIgnoreCase("avanzar")){
            robot1.avanzar(cantidadPasos);
        } else if(accion.equalsIgnoreCase("retroceder")){
            robot1.retroceder(cantidadPasos);
        }
        System.out.println("Desea poner a dormir al robot? Si/No");
        res=scanner.next();
}
        robot1.dormir();
    }
}
