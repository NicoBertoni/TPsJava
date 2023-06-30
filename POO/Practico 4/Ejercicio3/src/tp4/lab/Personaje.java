
package tp4.lab;


public abstract class Personaje {
    protected Position ubicacion;
    protected String nick;
    protected int vidas;
    protected int energia;
    protected char orientacion;

    public Personaje(Position ubicacion, String nick) {
        this.ubicacion = ubicacion;
        this.nick = nick;
        this.vidas = 3;
        this.energia = 100;
        this.orientacion = 'n';
    }

    public Position getUbicacion() {
        return ubicacion;
    }

    

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getVidas() {
        return vidas;
    }

    public int getEnergia() {
        return energia;
    }

    public char getOrientacion() {
        return orientacion;
    }

    @Override
    public String toString() {
        return "Personaje{" + "ubicacion=" + ubicacion + ", nick=" + nick + ", vidas=" + vidas + ", energia=" + energia + ", orientacion=" + orientacion + '}';
    }

   
    
    public void disparar(){
        if(energia>=10){
            System.out.println("disparando");
            energia-=10;
    }else{
            System.out.println("Energia insuficiente");
    }
    }
    public void girar(){
        switch (orientacion) {
            case 'n':
                orientacion='e';
                break;
            case 's':
                orientacion='o';
                break;    
            case 'e':
                orientacion='s';
                break;
            case 'o':
                orientacion='n';
                break;   
        }
    }
    public void avanzar(){
        
        switch (orientacion) {
            case 'n':
                ubicacion.setY(ubicacion.getY()-1);
                break;
            case 's':
                ubicacion.setY(ubicacion.getY()+1);
                break;    
            case 'e':
                ubicacion.setX(ubicacion.getX()+1);
                break;
            case 'o':
                ubicacion.setX(ubicacion.getX()-1);
                break;    
              
        }
    }
}