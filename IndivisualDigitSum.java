package ritu.Java8;

import java.util.Arrays;

public class IndivisualDigitSum {
    public static void main(String[] args) {
        int[] arr = {123, 456, 789};
        int totalSum = 0;
        for (int num : arr) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            totalSum += sum;
        }
        System.out.println(totalSum);

        //using stream
        int streamSum = Arrays.stream(arr).map(num -> {
            int sum = 0 ;
            while(num > 0){
                sum += num%10;
                 num /= 10;
            }
            return sum;
        }).sum();
        System.out.println("Using Stream : "+streamSum);
    }
//uisng stream


}
