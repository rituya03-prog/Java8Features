/*
package ritu.Java8;

import java.util.HashSet;
import java.util.Map;

import static ritu.leetCode.SubstringLongest.lengthOfLongestSubstring;

public class LongestSubstringWithoutRepeatingChar1 {
    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;*/
/**//*

        int start = 0;
        int currentln = 0;
        //  Map<Character, Integer> map = new java.util.HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int ch = 0; ch < str.length(); ch++) {
            char currentChar = str.charAt(ch);
            if (set.contains(currentChar)) {
                while (set.contains(currentChar)) {
                    set.remove(str.charAt(start));
                    start++;
                }
                set.add(currentChar);
                currentln = set.size();
                if (currentln > maxLength) {
                    maxLength = currentln;
                }
            }
          //  return maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = lengthOfLongestSubstring(str);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }

}
*/
