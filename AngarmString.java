package ritu.Java8;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AngarmString {
    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "tac";
        char[] ch1 = str1.toLowerCase().toCharArray();
        char[] ch2 = str2.toLowerCase().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        System.out.println("Are the strings anagrams? " + Arrays.equals(ch1, ch2));


    }
}
