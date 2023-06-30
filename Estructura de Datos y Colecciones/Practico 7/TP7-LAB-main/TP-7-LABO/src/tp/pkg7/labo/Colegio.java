/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg7.labo;
import Vistas.Menu;
import tp.pkg7.labo.Materia;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 *
 * @author Gonza
 */
public class Colegio {

private HashSet<Materia> materiasTotales = new HashSet<Materia>();    
private HashMap<Integer, Alumno> alumnosTotales= new HashMap<Integer,Alumno>();
private HashMap<Materia, Alumno> listaInscriptos= new HashMap<Materia,Alumno>();

//   public static void main(String[] args) {
//       Menu m = new Menu();
//       m.setVisible(true);
//  }

    public Colegio() {
       Materia m2 = new Materia(1,"Ingles",1);
       Materia m3 = new Materia(2,"Matematicas",1);
       Materia m4 = new Materia(3,"Laboratorio I",1);
       materiasTotales.add(m2);
       materiasTotales.add(m3);
       materiasTotales.add(m4);
       Alumno a= new Alumno(1001, "Lopez", "Martin");
       Alumno a1= new Alumno(1002, "Martinez", "Brenda");
       alumnosTotales.put(a.getLegajo(), a);
       alumnosTotales.put(a1.getLegajo(), a1);
    }
    public boolean inscribir(int m, int a){
        Alumno al=null;
        
        for (Map.Entry<Integer, Alumno> entry : alumnosTotales.entrySet()) {
            if(entry.getValue().getLegajo()==a){
                al=entry.getValue();
            }
            
        }
        
        
        boolean ok = true;
        
        for (Materia mt : materiasTotales) {
            for (Map.Entry<Materia, Alumno> entry : listaInscriptos.entrySet()) {
                if(entry.getValue().equals(al)){
                    if(entry.getKey().equals(mt)){
                        ok=false;
                    }
                }
                
            }
            if(mt.getIdMateria()==m && ok){
            listaInscriptos.put(mt,alumnosTotales.get(a));
            return true;
            }
        }
        return false;
    }
    public HashSet<Materia> getMateriasTotales() {
        return materiasTotales;
    }

    public void addMateriasTotales(Materia materia) {
        materiasTotales.add(materia);
    }

    public HashMap<Integer, Alumno> getAlumnosTotales() {
        return alumnosTotales;
    }

    public void addAlumnosTotales(Alumno alumno) {
        alumnosTotales.put(alumno.getLegajo(), alumno);
    }
    public HashMap<Materia,Alumno> getListaInscripto(){
        return listaInscriptos;
    }
     
}
