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
public class Arreglo {

    public static void sumarLista(int[] arr) {
        int suma = 0;
        for (int e : arr) {
            suma += e;
        }

        System.out.println("La suma es : " + suma);
        System.out.println("El promedio es : " + (suma / arr.length));
    }

    public static int buscarMayor(int[][] arr) {
        if (arr.length > 0) {
            int mayor = arr[0][0];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] > mayor) {
                        mayor = arr[i][j];
                    }
                }

            }
            return mayor;
        }
        return 0;
    }

    public static int cuentaVocal(String word) {

        String[] vocales = {"a", "e", "i", "o", "u"};

        String[] aux = word.split("");
        int numV = 0;
        for (String l : aux) {
            if (contiene(vocales, l)) {
                numV++;
            }
        }

        return numV;
    }

    private static boolean contiene(String[] arr, String c) {
        for (String l : arr) {
            if (l.equalsIgnoreCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static int cuentaCaracter(char c, String word) {
        int cant = 0;

        String enmin = word.toLowerCase();

        for (int i = 0; i < enmin.length(); i++) {
            if (c == enmin.charAt(i)) {
                cant++;
            }
        }

        return cant;
    }
}
