package basic_class_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Code_03_MinStack {
    public Stack<Integer> data;
    public Stack<Integer> min;

    public Code_03_MinStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("stack's size is > 0");
        }
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int num) {
        data.push(num);
        if (min.isEmpty() || num < min.peek()) {
            min.push(num);
        } else {
            min.push(min.peek());
        }
    }

    public int pop() {
        min.pop();
        return data.pop();
    }

    public Integer peek() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] argn) throws IOException {
        Code_03_MinStack minStack = new Code_03_MinStack(5);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        while ((read = br.readLine()) != null) {
            if (read.equals("-")) {
                int pop = minStack.pop();
                System.out.println("出栈：" + pop);
            } else if (read.equals("+")) {
                int peek = minStack.peek();
                System.out.println("栈顶元素：" + peek);
            } else if (read.equals("*")) {
                int min = minStack.getMin();
                System.out.println("最小值：" + min);
            } else {
                minStack.push(Integer.valueOf(read));
                System.out.println("入栈：" + read);
            }
        }
    }
}
