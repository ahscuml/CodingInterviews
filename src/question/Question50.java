package question;

import java.util.ArrayList;

/**
 * @author ahscuml
 * @date 2018/12/20
 * @time 20:22
 */
public class Question50 {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(4));
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int target) {
        // 和为100的整数序列
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
        for(int left = 1,right = 2; left < right ;) {
             int sum = (left + right) * (right - left + 1) / 2;
            if(sum == target) {
                res.add(new ArrayList<>(temp));
                temp.remove(0);
                sum = sum - left;
                left++;
            } else if (sum > target) {
                sum -= left;
                left++;
                temp.remove(0);
            } else {
                sum += right;
                right++;
                temp.add(right);
            }

        }
        return res;
    }
}
