public class Registro {
    public void procesarDatos(Persona p) {
        if(p instanceof Trabajador){
            System.out.println(p.getNombre());
            System.out.println(p.calcularEdad());
            p.cobrar();
            
        }else if(p instanceof Jubilado){
            System.out.println(p.getNombre());
            System.out.println(p.calcularDiasVividos());
            p.cobrar();
        }
    }
    public void hacerAportes(){
   
    }
}
