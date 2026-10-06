package ritu.Java8;

import java.util.*;
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
        int[] input = {35,23,44,2,41,35,35,2,16,44};
        List<Integer> output =Arrays.stream(input).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
              //  .entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()).skip(1).findFirst().get().getKey();
        System.out.println("top 2Most frequent element in the array: " + output);

        // Scientific games interview question: Sort the array based on frequency of elements in descending order

        Map<Integer, Long> output2 =Arrays.stream(input).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        List<Integer> arrList = output2.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .flatMap(entry ->
                        Collections.nCopies(
                                entry.getValue().intValue(),
                                entry.getKey()
                        ).stream()
                )
                .collect(Collectors.toList());
        System.out.println("maintain the order"+ arrList);

                //max(Map.Entry.comparingByValue()).get().getKey();
       // System.out.println("Most frequent element in the array: " + output);




    }
}
