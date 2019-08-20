package code.sort.simple;

/**
 * @author young
 * @ProjectName: Algorithm
 * @Description: TODO(插入排序)
 * @date 2018/11/28 9:47
 */
public class InsertSort {
    /**
     * 插入排序是简单排序中最快的排序算法，虽然时间复杂度仍然为O(n*n)，但是却比冒泡排序和选择排序快很多。
     *
     * 原理：
     *
     * 　　1、将指针指向某个元素，假设该元素左侧的元素全部有序，将该元素抽取出来，然后按照从右往左的顺序分别与其左边的元素比较，遇到比其大的元素便将元素右移，直到找到比该元素小的元素或者找到最左面发现其左侧的元素都比它大，停止；
     *
     *    2、此时会出现一个空位，将该元素放入到空位中，此时该元素左侧的元素都比它小，右侧的元素都比它大；
     *
     * 　　3、指针向后移动一位，重复上述过程。每操作一轮，左侧有序元素都增加一个，右侧无序元素都减少一个。
     */

    public static void main(String []args){
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        a = sort(a);
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i]+",");
        }

    }
    public static int[] sort(int[] arr){
        for(int i = 1; i < arr.length; ++i) {
            for(int point = i; point > 0 && arr[point] < arr[point - 1]; --point) {
                int temp = arr[point];
                arr[point] = arr[point - 1];
                arr[point - 1] = temp;
            }
        }
        return arr;
    }

}
