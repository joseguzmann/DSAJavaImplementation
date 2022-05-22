package io.github.joseguzmann.dsaimplementation;
import java.util.HashMap;

/**
 * @author Jose Guzman
 */

public class PatternMatching {
    public static int findBrute(char[] text, char[] pattern) {
        int m = text.length;
        int n = pattern.length;
        for(int i = 0; i <= m - n; i++) {
            int j = 0;
            while(j < n && pattern[j] == text[i + j]) {
                j++;
            }
            if(j == n) {
                return i;
            }
        }
        return -1;
    }

    public static int booyerMoore(char[] texto, char[] patron) {
        // Definición de longitudes
        int n = texto.length;
        int m = patron.length;

        if(m == 0) return 0; // Si el patrón se encuentra vacio

        // Definicion de la tabla de posiciones
        HashMap<Character, Integer> tabla = new HashMap<>();
        for(int i = 0; i < n; i++) {
            // Rellenar con todos los carácteres del texto en -1
            tabla.put(texto[i], -1);
        }
        for(int k = 0; k < m; k++) {
            // Rellenar con todos los caracteres del patrón
            tabla.put(patron[k], k);
        }

        // Se empieza a comparar de derecha a izquierda en el patrón
        int i = m - 1; // Indice en el texto
        int k = m - 1; // Indice en el patrón
        int j; // Indice de la ultima ocurrencia del caracter de fallo en el patrón

        while(i < n) {
            if(texto[i] == patron[k]) {
                if(k == 0) {
                    // Si k ya llegó a 0 quiere decir que todos los términos coincidieron
                    return i;
                }
                i--;
                k--;
            } else {
                j = tabla.get(texto[i]); // Evaluación de los dos casos
                if(j < k) {
                    i += m - (j + 1); // Si la última ocurrencia esta a la derecha
                } else if(j > k) {
                    i += m - k; // Si la última ocurrencia está a la izquierda
                }

                k = m - 1; // k se reinicia
            }
        }

        return -1; // No se encontro el patron
    }
}
