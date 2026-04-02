package 栈;

import java.util.Stack;

//两个栈模拟队列，最大容量n-2n
public class MyQueue {

    //用两个栈来实现一个队列。

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    // static 变量属于类本身，所有实例共享
    // 每次创建新对象时，构造器会覆盖之前实例的栈内容
    // 导致数据混乱
    // ✅ 使用静态初始化块
    // static {
    //   pushStack = new Stack<>();
    //   popStack = new Stack<>();
    //}
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (empty())
            throw new RuntimeException("队列为空");
        if (popStack.isEmpty()){transfer();}
        return popStack.pop();
    }

    public int peek() {
        if (empty())
            throw new RuntimeException("队列为空");
        if (popStack.isEmpty()){transfer();}
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public void transfer(){
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();  //实例对象调用，非类对象调用
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
    }

}
