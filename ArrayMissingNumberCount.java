/*
* ArrayChallenge
*  Take the of integers stored in arr and return the minimum number of
*  arr consecutive from the lowest number to Highest number.
*
*   for example : if arr contains [4,8,6] the output should be 2 because
*   two numbers need to be added to the array(5 and 7) to make it a consecutive
*   array of number from 4 to 8.
* */




package challenges;

import java.util.Arrays;

public class ArrayMissingNumberCount {
    // static variable count -> that holds missing elements count.
    static int count = 0;
    public static void arrayChallenge(int[] arr){
        int ptr = 0;
        while(ptr < arr.length-1){
            int i = arr[ptr];
            int j = arr[ptr+1];
            if(i+1 == j){
                ptr++;
            }
            else {
                while (++i < j){
                    count++;
                }
                ptr++;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,4};
        
        // Arrays.sort(); -> is used to sort the array.
        Arrays.sort(array);
        for(int i :array){
            System.out.println(i);
        }
        arrayChallenge(array);
        System.out.println("Missing number : "+count);

    }
}
