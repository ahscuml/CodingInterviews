package question;

/**
 * 二维数组中查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * LeetCode 240题
 * @author ahscuml
 * @date 2018/8/13
 * @time 16:21
 */
public class Question4 {
    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Find(3, array));
    }

    /**
     * 数组中查找的方向很关键
     * 最好的方法是行最小，列最大，这样子来寻找
     */
    public static boolean Find(int target, int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (array[row][column] == target) {
                return true;
            } else if (target < array[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
