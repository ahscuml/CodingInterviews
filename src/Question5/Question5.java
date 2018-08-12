package Question5;

/**
 * 字符串  替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author ahscuml
 * @date 2018/8/12
 * @time 21:05
 */
public class Question5 {
    /**
     * 替换空格函数   空格占一个字符，替换%20占3个字符，所以要移动字符串
     * 替换字符串有两个问题
     * 1. 是在原来的字符串上替换还是新建一个字符串替换
     * 2. 从前往后换需要经常移动，效率太低，所以采用从后往前替换，提前统计空格个数
     * 使用stringBuffer方便构造数组
     */
    private static String replace(StringBuffer str) {
        // 统计空格的个数 字符用单引号
        int countnum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                countnum++;
            }
        }
        // 旧数组的下标
        int oldindex = str.length() - 1;
        // 新数组的长度
        int newlength = str.length() + 2 * countnum;
        // 更改数组的长度
        str.setLength(newlength);
        for (int i = newlength - 1; i >= 0; i--) {
            if (str.charAt(oldindex) == ' ') {
                str.setCharAt(i--,'%');
                str.setCharAt(i--,'0');
                str.setCharAt(i,'2');
            } else {
                str.setCharAt(i,str.charAt(oldindex));
            }
            oldindex--;
        }
        return str.toString();
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String str = "a b c ";
        StringBuffer strbuf = new StringBuffer(str);
        System.out.println(replace(strbuf));
    }
}
