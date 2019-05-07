package basic_class_04;

import java.util.LinkedList;
import java.util.Queue;

public class Code_04_SerialByPre {
    public static class Node {
        public int value;
        public Node right;
        public Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String res) {
        String[] values = res.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
