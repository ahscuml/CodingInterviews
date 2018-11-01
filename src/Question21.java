import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author ahscuml
 * @date 2018/11/1
 * @time 21:37
 */
public class Question21 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        reOrderArrayWithoutSeq(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 简单的分开奇数和偶数，不考虑顺序,双指针解决问题
     * */
    private static void reOrderArrayWithoutSeq(int[] array) {
        int n = array.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while ((array[i] & 1) == 1) {
                i++;
            }
            while ((array[j] & 1) == 0) {
                j--;
            }
            if (i < j){
                swap(array,i,j);
                i++;
                j--;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 保持相对位置，复制一下数组
     * */
    public void reOrderArray(int [] array) {
        // 最开始想到交换，双指针，不可行
        // 同时还要保证相对位置不变
        int n = array.length;
        // 边界条件，数组为空的时候也要考虑
        int[] res = new int[n];
        // 奇数的计数器
        int count = 0;
        for(int i = 0; i < n; i++) {
            // 如果是奇数，计数器加1
            if((array[i] & 1) == 1) {
                count++;
            }
        }
        int i = 0,j = count;
        for(int k = 0; k < n; k++) {
            if((array[k] & 1) == 1) {
                res[i] = array[k];
                i++;
            } else {
                res[j] = array[k];
                j++;
            }
        }
        for(int k = 0; k < n; k++) {
            array[k] = res[k];
        }
    }
}
