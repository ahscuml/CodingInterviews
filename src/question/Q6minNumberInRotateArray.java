package question;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author ahscuml
 * @date 2018/8/16
 * @time 11:18
 */
public class Q6minNumberInRotateArray {
    /**
     * 这道题相对来说比较简单，有三种不同的方法
     * 1. 方法一是简单地遍历数组，找到最小的，时间复杂度O(n)
     * 2. 方法二是利用旋转数组的特性，同样遍历数组，找到前一个比后一个大的元素，这样子不用遍历完全数组，时间复杂度也是O(n)
     * 3. 方法三是利用旋转数组排序特性，结合二分查找来进行查找，时间复杂度O(logn) 重点是要判断各种等号的情形
     */
    public static int minNumberInRotateArray(int[] array) {
        // 判断输入是否有误
        if (array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length - 1, middle = 0;
        while (array[left] >= array[right]) {
            // 只剩下最后两个，左边还比右边大，肯定右边小
            if (right - left <= 1) {
                middle = right;
                break;
            }
            // 这样写是为了防止溢出
            middle = left + (right - left) / 2;
            // 要包括等于，因为有可能有相等的元素
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }
}
