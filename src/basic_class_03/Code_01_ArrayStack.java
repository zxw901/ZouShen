package basic_class_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_01_ArrayStack {
    private int[] arr;
    private int index;

    public Code_01_ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new int[initSize];
        index = 0;
    }

    public void push(int i) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        arr[index++] = i;
    }

    public int pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return arr[--index];
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }

    public static void main(String[] argn) throws IOException {
        Code_01_ArrayStack arrayStack = new Code_01_ArrayStack(10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        while ((read = br.readLine()) != null) {
            if (read.equals("-")) {
                int pop = arrayStack.pop();
                System.out.println("出栈：" + pop);
            } else if (read.equals("+")) {
                int peek = arrayStack.peek();
                System.out.println("栈顶元素：" + peek);
            } else {
                arrayStack.push(Integer.valueOf(read));
                System.out.println("入栈：" + read);
            }
        }
    }
}
