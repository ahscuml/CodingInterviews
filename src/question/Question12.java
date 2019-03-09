package question;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author ahscuml
 * @date 2018/8/17
 * @time 9:28
 */
public class Question12 {
    /**
     * 测试用例
     * a b c e
     * s f c s
     * a d e e
     * str = bceed
     * str1 = abcb
     */
    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e',};
        char[] str1 = {'b', 'c', 'c', 'e', 'd'};
        char[] str2 = {'a', 'b', 'c', 'b'};
        System.out.println(hasPath(matrix, rows, cols, str1));
        System.out.println(hasPath(matrix, rows, cols, str2));
    }

    /**
     * 回溯法
     * 判断是否存在路径
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 记录字符是否进行过判断
        boolean[] visited = new boolean[matrix.length];
        //  遍历数组找到与第一个匹配的
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isMatch(matrix, rows, cols, str, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断当前字符是否与字符串中对应
     *
     * @param matrix  初始矩阵
     * @param rows    矩阵的行数
     * @param cols    矩阵的列数
     * @param str     路径数组
     * @param visited 是否判断过的数组
     * @param i       索引行坐标i
     * @param j       索引列坐标j
     * @param k       路径数组下标
     */
    private static boolean isMatch(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int i, int j, int k) {
        // 通过i与j来计算一维数组的下标
        int index = i * cols + j;

        // 递归终止条件 越界或者不匹配，或者访问过当前元素
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || visited[index] == true) {
            return false;
        }

        // 匹配完成
        if (k == str.length - 1) {
            return true;
        }
        // 如果被访问过那么设为true(注意必须放到下面的判断语句外，因为判断语句循环调用，访问不到)
        visited[index] = true;

        // 回溯，递归寻找,如果周围四个存在相同的，那么返回匹配
        if (isMatch(matrix, rows, cols, str, visited, i - 1, j, k + 1) ||
                isMatch(matrix, rows, cols, str, visited, i, j - 1, k + 1) ||
                isMatch(matrix, rows, cols, str, visited, i + 1, j, k + 1) ||
                isMatch(matrix, rows, cols, str, visited, i, j + 1, k + 1)) {
            return true;
        }
        //如果不匹配
        visited[index] = false;
        return false;
    }
}
