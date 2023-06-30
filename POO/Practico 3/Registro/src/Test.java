
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gonza
 */
public class Test {
            public static void main(String[] args) {
            Registro r = new Registro();
            LocalDate jubi= LocalDate.of(1960,05,31);
            LocalDate d= LocalDate.of(1992,02,23);
            Jubilado j= new Jubilado("Peron",1234543,jubi,"Avenida Julio Roca 912");
            Trabajador t = new Trabajador("Ricardo",39435324,d,"Avenida fantasia 2023",100000);
            //System.out.println(t.calcularEdad());
            //System.out.println(t.calcularDiasVividos());
            //t.cobrar();
            r.procesarDatos(t);
            r.procesarDatos(j);
            }
}
