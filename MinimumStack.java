package leetcode;

import java.util.Stack;

public class MinimumStack {

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

class MinStack{

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(minStack.isEmpty() || x<= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
