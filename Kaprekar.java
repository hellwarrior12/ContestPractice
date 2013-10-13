package primerejercicio;

import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {

    static int contador = 0;

    public boolean repDigits(String str) {
        boolean esrepDigits = false;
        contador = 0;
        char charArray[] = str.toCharArray();

        return esrepDigits;
    }

    public void aplicarKaprekar(String str) {


        while (str.length() < 4) {
            str = "0" + str;
        }
        String digitosMayores = "";
        String digitosMenores = "";
        if (str.equals("6174")) {
            System.out.println(Kaprekar.contador);
        }
        char[] charArray = str.toCharArray();
        int array[] = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.getNumericValue(charArray[i]);
        }
        Arrays.sort(array);
        for (int i = 0, j = array.length - 1; i < array.length && j >= 0; i++, j--) {
            digitosMenores += array[i];
            digitosMayores += array[j];
        }
        // System.out.println(digitosMenores);
        //System.out.println(digitosMayores);
        int cifraMayor = Integer.parseInt(digitosMayores);
        int cifraMenor = Integer.parseInt(digitosMenores);
        int resultadoEsperado = 6174;
        int resultadoActual;
        Kaprekar.contador++;
        resultadoActual = cifraMayor - cifraMenor;
        //System.out.println(resultadoActual);
        if (resultadoActual != resultadoEsperado) {
            String strd = "" + resultadoActual;

            new Kaprekar().aplicarKaprekar(strd);
        }




    }

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int respuestas[];
        Kaprekar obj = new Kaprekar();
        int numeroCasos;
        boolean digitoRepetido = false;
        numeroCasos = myScan.nextInt();
        String numeros[] = new String[numeroCasos];
        respuestas=new int[numeroCasos];
        int contadorRespuestas=0;
        for (int i = 0; i < numeroCasos; i++) {
            numeros[i] = myScan.next();
            char charArray[] = numeros[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(charArray[j])
                        != Character.getNumericValue(charArray[j + 1])) {
                    digitoRepetido = true;
                }
            }
            if (digitoRepetido) {
                if (numeros[i].equals("6174")) {
                    //System.out.println(Kaprekar.contador);
                    respuestas[contadorRespuestas]=Kaprekar.contador;
                    contadorRespuestas++;
                } else {
                    obj.aplicarKaprekar(numeros[i]);
                    //System.out.println(Kaprekar.contador);
                    respuestas[contadorRespuestas]=Kaprekar.contador;
                    contadorRespuestas++;
                    Kaprekar.contador = 0;
                }
            } else {
                //System.out.println("8");
                respuestas[contadorRespuestas]=8;
                contadorRespuestas++;
            }
            digitoRepetido = false;
        }
        for(int contadors=0;contadors<numeroCasos;contadors++){
            System.out.println(respuestas[contadors]);
        }
        /*System.out.println(numeroCasos);
         for(int i=0;i<numeroCasos;i++){
         System.out.println(numeros[i]);           
         }*/

    }
}
