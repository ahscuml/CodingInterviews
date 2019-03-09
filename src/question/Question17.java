package question;

/**
 * 打印从1到最大的n数
 * @author ahscuml
 * @date 2018/11/1
 * @time 20:59
 */
public class Question17 {
    public static void main(String[] args) {
        Print1ToMaxOfNDigits(2);
    }

    /**
     * 大数问题，应用字符串来表示大数(int，long 都无法表示)
     * */
    private static void Print1ToMaxOfNDigits(int n) {
        if (n < 0) {
            return;
        }
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            s.append('0');
        }
        for (int i = 0; i < 10; i++) {
            s.setCharAt(0,(char)(i +'0'));
            Print1ToMaxOfNDigitsRec(s, n, 0);
        }
    }

    private static void Print1ToMaxOfNDigitsRec(StringBuffer s, int n, int index) {
        if(index == n - 1){
            PrintNumber(s);
            return;
        }

        for(int i = 0; i < 10; i++){
            s.setCharAt(index+1, (char) (i+'0'));
            Print1ToMaxOfNDigitsRec(s, n, index+1);
        }
    }

    public static void PrintNumber(StringBuffer s){
        boolean isBeginning0 = true;
        for(int i = 0; i < s.length(); i++){
            if(isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }
}
