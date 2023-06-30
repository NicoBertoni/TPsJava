/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg5;

/**
 *
 * @author juany
 */
public class PruebaArreglo {
    
    public static void main(String[] args) {
        String palabra = "Esternocleidomastoideo";
        
        int[] numeros = {1,12,9,22,3,5,13,45};
        
        int[][] biNum = {{3,25,6},{1,10},{20,30,12,18},{4}};
        
        
        System.out.println(Arreglo.cuentaVocal(palabra));
        System.out.println("El caracter e se repite en la palabra :");
        System.out.println(Arreglo.cuentaCaracter('e', palabra));
        
        System.out.println("El mayor del arreglo bidimencional irregular es : "+Arreglo.buscarMayor(biNum));
        
        Arreglo.sumarLista(numeros);
    }
    
}
