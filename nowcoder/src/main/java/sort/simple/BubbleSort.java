package sort.simple;

/**
 * @author young
 * @ProjectName: Algorithm
 * @Description: TODO(冒泡排序)
 * @date 2018/11/28 9:17
 */
public class BubbleSort {

    /**
     * 1、从第一个数据开始，与第二个数据相比较，如果第二个数据小于第一个数据，则交换两个数据的位置。
     *
     * 　　2、指针由第一个数据移向第二个数据，第二个数据与第三个数据相比较，如果第三个数据小于第二个数据，则交换两个数据的位置。
     *
     * 　　3、依此类推，完成第一轮排序。第一轮排序结束后，最大的元素被移到了最右面。
     *
     * 　　4、依照上面的过程进行第二轮排序，将第二大的排在倒数第二的位置。
     *
     * 　　5、重复上述过程，没排完一轮，比较次数就减少一次。
     * @param args
     */


    public static void main(String []args){
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        sort(a,a.length);
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i]+",");
        }

    }

    public static int[] sort(int[] arr ,int length){
        int start;
        for (int curLen = length; curLen>=2;curLen--){
            start = 0;
            while (start+1<curLen){
                if (arr[start] > arr[start+1]){
                    int temp = arr[start];
                    arr[start] = arr[start+1];
                    arr[start+1] = temp;
                }
                start++;
            }

        }
        return arr;
    }


}
