
package tp4.lab;


    public class Guerrero extends Personaje {
    private boolean caballo;

    public Guerrero(Position ubicacion, String nick) {
        super(ubicacion, nick);
        caballo = true;
    }
    @Override
    public void avanzar(){
        if(caballo){
            switch(orientacion){
                case 'n': ubicacion.setY(ubicacion.getY()-10);break;
                case 'e': ubicacion.setX(ubicacion.getX()+10);break;
                case 's': ubicacion.setY(ubicacion.getY()+10);break;
                case 'o': ubicacion.setX(ubicacion.getX()-10);break;
            
            }
            System.out.println("El guerrero está avanzando con su caballo hacia "+orientacion);
            
        }else{
            super.avanzar();
            System.out.println("El guerrero está avanzando hacia "+orientacion);
        }
    }
    
    public void disparar(){
        if(energia>=10){
            System.out.println("Disparando");
            energia -=10;
            if(energia<30 && caballo){
                caballo = false;
                System.out.println("Chau el horse");
            }
        }else{
            System.out.println("No hay energí­a para disparar");
        }
    
    }

    public boolean isCaballo() {
        return caballo;
    }
    
    
    
}


