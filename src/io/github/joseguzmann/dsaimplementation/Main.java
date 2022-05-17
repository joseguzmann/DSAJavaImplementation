package io.github.joseguzmann.dsaimplementation;


/**
 * @author Jose Guzman
 */

public class Main {
    public static void main(String[] args) {
        char[] string1 = new char[7];
        string1[0] = 'j';
        string1[1] = 'o';
        string1[2] = 's';
        string1[3] = 'e';
        string1[4] = 'd';
        string1[5] = 'f';
        string1[6] = 'g';


        char[] string2 = new char[3];
        string2[0] = 'd';
        string2[1] = 'f';
        string2[2] = 'g';

        System.out.println(PatternMatching.findBrute(string1, string2));

    }
}
