package io.github.joseguzmann.dsaimplementation;


/**
 * @author Jose Guzman
 */

public class Main {
    public static void main(String[] args) {
        char[] string1 = new char[20];
        string1[0] = 'a';
        string1[1] = 'b';
        string1[2] = 'a';
        string1[3] = 'c';
        string1[4] = 'a';
        string1[5] = 'a';
        string1[6] = 'b';
        string1[7] = 'a';
        string1[8] = 'd';
        string1[9] = 'c';
        string1[10] = 'a';
        string1[11] = 'b';
        string1[12] = 'a';
        string1[13] = 'c';
        string1[14] = 'a';
        string1[15] = 'b';
        string1[16] = 'a';
        string1[17] = 'a';
        string1[18] = 'b';
        string1[19] = 'b';


        char[] string2 = new char[6];
        string2[0] = 'a';
        string2[1] = 'b';
        string2[2] = 'a';
        string2[3] = 'c';
        string2[4] = 'a';
        string2[5] = 'b';

        System.out.println(PatternMatching.booyerMoore(string1, string2));

    }
}
