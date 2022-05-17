package io.github.joseguzmann.dsaimplementation;

/**
 * @author Jose Guzman
 */

public class PatternMatching {
    public static int findBrute(char[] text, char[] pattern) {
        System.out.println("entrar");
        int m = text.length;
        int n = pattern.length;
        for(int i = 0; i <= m - n; i++) {
            System.out.println("Entrar al for");
            int j = 0;
            while(j < n && pattern[j] == text[i + j]) {
                j++;
            }
            if(j == m) {
                return i;
            }
        }
        return -1;
    }
}
