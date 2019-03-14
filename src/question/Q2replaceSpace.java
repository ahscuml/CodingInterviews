package question;

/**
 * 字符串  替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author ahscuml
 * @date 2018/8/12
 * @time 21:05
 */
public class Q2replaceSpace {
    /**
     * 替换空格函数   空格占一个字符，替换%20占3个字符，所以要移动字符串
     * 替换字符串有两个问题
     * 1. 是在原来的字符串上替换还是新建一个字符串替换
     * 2. 从前往后换需要经常移动，效率太低，所以采用从后往前替换，提前统计空格个数
     * 使用stringBuffer方便构造数组
     */
    private static String replace(StringBuffer str) {
        // 判断输入是否合法
        if (str == null || str.length() <=0){
            return "输入错误";
        }

        // 统计空格的个数 字符用单引号
        int countnum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                countnum++;
            }
        }
        // 旧字符串的下标
        int oldindex = str.length() - 1;
        // 新字符串的长度
        int newlength = str.length() + 2 * countnum;
        // 这个是新字符串的下标,指向该放的字符
        int newindex = newlength - 1;
        // 更改数组的长度
        str.setLength(newlength);
        // 以oldindex为条件运行， --符号先进行运算再进行减1操作
        for (; oldindex >= 0; oldindex--) {
            if (str.charAt(oldindex) == ' ') {
                str.setCharAt(newindex--, '0');
                str.setCharAt(newindex--, '2');
                str.setCharAt(newindex--, '%');
            } else {
                str.setCharAt(newindex--, str.charAt(oldindex));
            }
        }

        return str.toString();
    }

    /**
     * 另外一种解法，因为是C++的问题转换到Java上，所以还有这种简单解法，用正则表达式来进行替换
     */
    private static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String str = "a b  cd";
        StringBuffer strbuf = new StringBuffer(str);
        System.out.println(replace(strbuf));
        // 检测错误输入
        String strwrong = "";
        StringBuffer strbufw = new StringBuffer(strwrong);
        System.out.println(replace(strbufw));
        // 正则表达式法
        String str1 = "d e  fg";
        StringBuffer strbuf1 = new StringBuffer(str1);
        System.out.println(replaceSpace(strbuf1));
    }
}
