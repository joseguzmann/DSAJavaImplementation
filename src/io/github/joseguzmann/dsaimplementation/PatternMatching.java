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


    /**
     *
     * @param texto
     * @param patron
     * @return
     */
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
                    i += m - (j + 1); // Si la última ocurrencia está a la derecha
                } else if(j > k) {
                    i += m - k; // Si la última ocurrencia está a la izquierda
                }

                k = m - 1; // k se reinicia
            }
        }

        return -1; // No se encontró el patron
    }

    /**
     *
     * @param texto
     * @param patron
     * @return
     */
    public static int KMP(char[] texto, char[] patron) {
        // Definición de las longitudes
        int n = texto.length;
        int m = patron.length;

        if(m == 0) return 0; // Si el patrón a buscar está vacío

        // Definimos el array que contiene la función de fallo
        int[] fallo = funcionFallo(patron);

        // Empezamos por la izquierda
        int j = 0; // Indice en el texto
        int k = 0; // Indice en el patron

        while(j < n) {
            if(texto[j] == patron[k]) {
                if(k == m - 1) { // Si el patrón ya está completo
                    return j - m + 1; // Retorna el índice donde empieza el patrón en el texto
                }
                j++;
                k++;
            } else if(k > 0) {
                k = fallo[k-1]; // Se reutiliza el sufijo
            } else {
                j++; // Se aumenta únicamente el índice en el texto
            }
        }

        return -1; // No hay coincidencia
    }

    public static int[] funcionFallo(char[] patron) {
        int m = patron.length;
        int[] fallo = new int[m]; // Definición de la longitud de la funcion de fallo

        // Definición de lo índices
        int j = 1; // Recorre los sufijos
        int k = 0; // Recorre los prefijos

        while(j < m) {
            if(patron[j] == patron[k]) {
                fallo[j] = k + 1; // Se aumenta el valor de la posicion j en la funcion de fallo
                j++;
                k++;
            } else if(k > 0) {
                // la posición de j se mantiene y k retrocede para seguir construyendo un patron
                k = fallo[k-1];
            } else {
                j++; // la posición de j aumenta
            }
        }
        return fallo;
    }
}
