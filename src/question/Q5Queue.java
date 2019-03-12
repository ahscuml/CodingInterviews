package question;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author ahscuml
 * @date 2018/9/11
 * @time 11:02
 */
public class Q5Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // 用两个先进后出完成一个先进先出    大问题换成小问题解决

    /**
     * 进入队列
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队
     */
    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Query is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
