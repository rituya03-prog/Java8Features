package ritu.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamFrequency {

    public static void main(String[] args) {

        String str = "hello world";
        long count = str.chars().filter(ch -> ch == 'o').count();
        System.out.println("Frequency of 'o' in the string: " + count);

       String[] arr = {"java", "spring", "java", "kafka", "spring", "java"};
     Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ": " + v));

     int[] arrnum = {1, 2, 2,2, 3, 3, 3, 4};
        Arrays.stream(arrnum).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ": " + v));

     //most frequent element in an array
        int[] input = {35,23,44,2,2,41,35,35,16,44};
        Map<Integer,Long> output =Arrays.stream(input).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            //    .entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()).skip(1).findFirst().get().getKey();

        // Scientific games interview question: Sort the array based on frequency of elements in descending order
        List<Integer> arrList = Arrays.stream(input).boxed()
                .sorted((a,b) -> Long.compare(output.get(b), output.get(a))).collect(Collectors.toList());
        System.out.println(arrList);

                //max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Most frequent element in the array: " + output);
    }
}
