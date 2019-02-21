/**
 * 不修改数组找出数组中重复的数字
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但是不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 *
 * @author ahscuml
 * @date 2018/8/7
 * @time 16:19
 */
public class Question3_2 {
    /**
     * 题目中要求不能修改输入数组，那么上一个题目中利用数组下标的方法就不可用了
     * 同样的，排序的方法也不可用，除非牺牲空间复杂度，重新找一个辅助数组
     * 同样如果牺牲时间复杂度，可以考虑空间复杂度更低的方法
     * */

    /**
     * 牺牲空间复杂度，复制到另一个数组与数组值对应的下标位置。
     */
    private static int findmintime(int[] numbers, int length) {
        // 判断数组是否有效
        if (numbers == null || length <= 0) {
            return -1;
        }
        // 辅助数组
        int[] numberscopy = new int[length];
        for (int i = 0; i < length; i++) {
            // 判断输入是否有效
            if (numbers[i] <= 0 || numbers[i] >= length) {
                return -1;
            }
            if (numbers[i] == numberscopy[numbers[i]]) {
                return numbers[i];
            } else {
                numberscopy[numbers[i]] = numbers[i];
            }
        }
        return -1;
    }

    /**
     * 牺牲时间复杂度换取空间复杂度，类似于二分查找的方法，统计部分数字出现的概率
     * 缺点是不能找到所有的重复数字，但是满足题目要求
     */
    private static int findminspace(int[] numbers, int length) {
        // 判断数组是否有效
        if (numbers == null || length <= 0) {
            return -1;
        }

        int start = 1, end = length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            int count = checknum(numbers, length, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 辅助函数，帮助统计数字出现的概率
     *
     * @param start 开始数字
     * @param end   结束数字
     */
    private static int checknum(int[] numbers, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) {
        // 总共三组测试数据
        int[] numberswrong = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] numberswrong1 = {};
        int numberswrong1_length = numberswrong1.length;
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        int length = numbers.length;
        System.out.println(findmintime(numbers, length));
        System.out.println(findmintime(numberswrong, length));
        System.out.println(findmintime(numberswrong1, numberswrong1_length));
        System.out.println("---------------------------------------");
        System.out.println(findminspace(numbers, length));
        System.out.println(findminspace(numberswrong, length));
        System.out.println(findminspace(numberswrong1, numberswrong1_length));
        System.out.println("---------------------------------------");
        System.out.println(findDuplicate(numbers, length));
        // System.out.println(findDuplicate(numberswrong, length));
        System.out.println(findDuplicate(numberswrong1, numberswrong1_length));

    }

    /**
     * 最优方法，空间复杂度O(1); 参考leetco第287题
     * */
    public static int findDuplicate(int[] nums, int length) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
