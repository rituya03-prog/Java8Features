package ritu.Java8;

public class LongestString {

    public static void main(String[] args) {

        String str = "My name is Dileep Kumar Yadav, I lived in Kulalumpur Malaysia";
        String[] words = str.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest word: " + longestWord);
    }
}
