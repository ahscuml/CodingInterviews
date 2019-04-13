package question;

/**
 * @author ahscuml
 * @date 2019/4/13
 * @time 10:35
 */
public class Q20StringPresentInteger {
    private int index = 0;

    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 首先是先判断小数点之前的是否是整数(可正可负)
     * 然后判断小数点
     * 然后判断小数点之后的(只能是无符号数)
     * 最后判断是否是指数
     */
    public boolean isNumeric(char[] str) {
        // 没有字符串
        if (str.length < 1)
            return false;

        // 判断前面是否存在整数
        boolean flag = scanInteger(str);

        // 此时的index已经是除了整数的下一个符号的下标了，现在判断是否有小数点
        if (index < str.length && str[index] == '.') {
            index++;
            // 小数点判断完成，现在判断小数点之后，由于小数点可以没数字，所以还要与上flag
            flag = scanUnsignedInteger(str) || flag;
        }
        // 现在的index是e或E上的
        // 如果出现‘E’或者‘e’，那么后面是指数部分
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }
        // 最后全部判断完成看是否已经到头了
        return flag && index == str.length;
    }

    // 有符号数的判断
    private boolean scanInteger(char[] str) {
        // 如果是有符号数，转换为无符号数
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);

    }

    // 无符号数的判断
    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        // index不要越界，而且还要大于等于0，并且小于等于9
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }
}
