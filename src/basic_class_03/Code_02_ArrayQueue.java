package basic_class_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code_02_ArrayQueue {
    private int[] array;
    private int start;
    private int end;
    private int size;

    public Code_02_ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        array = new int[initSize];
        start = 0;
        end = 0;
        size = 0;
    }

    public void push(int num) {
        if (size == array.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        array[end++] = num;
        if (end == array.length) {
            end = 0;
        }
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        int tmp = array[start++];
        if (start == array.length) {
            start = 0;
        }
        size--;
        return tmp;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[start];
    }

    public static void main(String[] argn) throws IOException {
        Code_02_ArrayQueue arrayQueue = new Code_02_ArrayQueue(5);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        while ((read = br.readLine()) != null) {
            if (read.equals("-")) {
                int pop = arrayQueue.poll();
                System.out.println("出队：" + pop);
            } else if (read.equals("+")) {
                int peek = arrayQueue.peek();
                System.out.println("栈顶元素：" + peek);
            } else {
                arrayQueue.push(Integer.valueOf(read));
                System.out.println("入队：" + read);
            }
            System.out.println(Arrays.toString(arrayQueue.array));
        }
    }
}
