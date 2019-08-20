package code.search;

import java.util.Scanner;

/**
 * @author young
 * @ProjectName: Algorithm
 * @Description: TODO(二分法查找)
 * @date 2018/11/27 9:06
 */
public class Dichotomy {
    public static void main(String[] args) {
        int [] arr = new int[]{12, 13,14,15,16,18,25,30,32};
        System.out.println(dichotomySearch(arr, 17));

    }

    public static int dichotomySearch(int[] arr,int key){
        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        while(start <= end) {
            ++count;
            System.out.println(count);
            int middle = (start + end) / 2;
            if (key > arr[middle]) {
                start = middle + 1;
            } else {
                if (key >= arr[middle]) {
                    return middle;
                }

                end = middle - 1;
            }
        }
        return -1;
    }
}
