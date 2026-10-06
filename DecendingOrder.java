package ritu.Java8;

public class DecendingOrder {
    public static void main(String[] args) {
        int[] arr ={2, 5, 6, 4, 1, 3, 10, 8, 7};
        for(int i=0; i<arr.length-1; i++){
            for(int j = i+1; j < arr.length ; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
