package 栈;

import java.util.Stack;

//最小栈-155
public class MinStack_155 {

//    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//    实现 MinStack 类:
//    MinStack() 初始化堆栈对象。
//    void push(int val) 将元素val推入堆栈。
//    void pop() 删除堆栈顶部的元素。
//    int top() 获取堆栈顶部的元素。
//    int getMin() 获取堆栈中的最小元素。
    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack_155() {
        stk = new Stack<>();
        minStk = new Stack<>();
        minStk.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stk.push(val);
        minStk.push(Math.min(minStk.peek(), val));
    }

    public void pop() {
        if (stk.isEmpty())
            return;
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //-3
        minStack.pop();
        System.out.println(minStack.top());//0
        System.out.println(minStack.getMin());//-2


    }
}
