package io.github.joseguzmann.dsaimplementation;


import static java.lang.System.currentTimeMillis;

/**
 * @author Jose Guzman
 */

public class Main {
    public static void main(String[] args) {
        String texto = "A BD ABL VBTLGTOTMLXML";
        String palabra = "OTMLXML";

        char[] string1 = texto.toCharArray();
        char[] string2 = palabra.toCharArray();

        int indice_respuesta = PatternMatching.booyerMoore(string1, string2);

        System.out.println("Índice: " + indice_respuesta);

    }
}
