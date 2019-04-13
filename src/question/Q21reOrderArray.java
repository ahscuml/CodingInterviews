package question;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/4/13
 * @time 11:36
 */
public class Q21reOrderArray {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reOrderArrayWithoutSeq(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 简单的分开奇数和偶数，不考虑顺序,双指针解决问题
     */
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
            if (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 利用空间换时间的想法
     */
    public void reOrderArray(int[] array) {
        // 最开始想到交换，双指针，不可行
        // 同时还要保证相对位置不变
        int n = array.length;
        // 边界条件，数组为空的时候也要考虑
        int[] res = new int[n];
        // 奇数的计数器
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 如果是奇数，计数器加1
            if ((array[i] & 1) == 1) {
                count++;
            }
        }
        int i = 0, j = count;
        for (int k = 0; k < n; k++) {
            if ((array[k] & 1) == 1) {
                res[i] = array[k];
                i++;
            } else {
                res[j] = array[k];
                j++;
            }
        }
        for (int k = 0; k < n; k++) {
            array[k] = res[k];
        }
    }
}
