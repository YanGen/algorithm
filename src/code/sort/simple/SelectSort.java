package code.sort.simple;

/**
 * @author young
 * @ProjectName: Algorithm
 * @Description: TODO(选择排序)
 * @date 2018/11/28 9:38
 */
public class SelectSort {

    /**
     * 选择排序是对冒泡排序的改进，它的比较次数与冒泡排序相同，但交换次数要小于冒泡排序。当数据量较大时，效率会有很大的提升，但时间复杂度仍为O(n*n)
     *
     * 原理：
     *
     * 　　1、从第一个元素开始，分别与后面的元素向比较，找到最小的元素与第一个元素交换位置；
     *
     * 　　2、从第二个元素开始，分别与后面的元素相比较，找到剩余元素中最小的元素，与第二个元素交换；
     *
     * 　　3、重复上述步骤，直到所有的元素都排成由小到大为止。
     * @param args
     */

    public static void main(String []args){
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        sort(a);
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i]+",");
        }

    }
    public static int[] sort(int[] arr){

        for (int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
