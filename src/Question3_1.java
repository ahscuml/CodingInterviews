/**
 * 找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 * @author ahscuml
 * @date 2018/8/7
 * @time 16:18
 */
public class Question3_1 {
    // 循环遍历，这也太蠢了（我第一个想到的竟然是这个）
    // 利用排序，然后找到重复的
    // 利用哈希表，牺牲空间复杂度，获得时间复杂度

    // 利用数组内的交换，找到重复内容
    /**
     * 官方的C++代码，自己改成Java
     * */
    public static int duplicate(int numbers[]) {
        int length = numbers.length;
        // 判断输入是否有问题，先判断数组，再判断数组的输入
        if (numbers == null || length <= 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return -1;
            }
        }
        for (int i = 0; i < length; i++) {
            // 确保第i个位置放上了i
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                // 交换numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 交换函数
     */
    private static void swap(int[] matrix, int i, int j) {
        int temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // 有序
        int[] matrix = {1, 5, 4, 2, 5, 6, 0};
        // 无序
        int[] matrix1 = {4, 0, 5, 3, 6, 2, 1};
        System.out.println(duplicate(matrix));
        System.out.println(duplicate(matrix1));
    }
}
