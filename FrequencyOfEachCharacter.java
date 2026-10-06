package ritu.Java8;

import java.util.HashMap;

public class FrequencyOfEachCharacter {
    public static void main(String[] args) {
        String str = "Dileep Kumar Yadav";
        char[] ch = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : ch){

            map.put(c, map.getOrDefault(c, 0) + 1);
        }
       // System.out.println(map);
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
