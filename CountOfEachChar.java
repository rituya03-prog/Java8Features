package ritu.Java8;

public class CountOfEachChar {
    public static void main(String[] args) {
        // Given i/p - > str="MMMNNNNOOM";
        // Expected o/p -> 3M4N2O1M;
        String str = "MMMNNNNOOM";
        // Implementation for counting each character would go here

        int count = 1;
        for (int i = 1; i < str.length() ; i++){
            if (str.charAt(i) == str.charAt(i-1)) {
                count++;
            } else  {
                System.out.print(count + "" + str.charAt(i-1));
                count = 1;
                
            }
            System.out.println(count  +""+ str.charAt(str.length()-1));
        }
        }
        
        
    }

