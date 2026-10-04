package ritu.Java8;

public class MaximumElement {
    public static void main(String[] args) {
       int arr[] = {2, 5, 6, 4, 1, 3, 10, 8, 7};

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        for(int num : arr){
            if( num > largest){
                secondlargest = largest;
                largest = num;

            }else if(num > secondlargest ){
                secondlargest = num;
            }

            if (num < smallest){
                secondSmallest = smallest;
                smallest = num;

            } else if (num < secondSmallest ) {
                secondSmallest = num;

            }
        }


        System.out.println("largest "+largest);
        System.out.println("smallest : "+secondlargest);
        System.out.println(secondSmallest);
    }
}
