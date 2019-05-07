package basic_class_03;

import java.util.Stack;

public class Code_13_IsPalindrome {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printLinkedList(Node head) {
        System.out.println("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    //need n extra space
    public static boolean IsPalindrome1(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (tmp != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean IsPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        Stack<Node> stack = new Stack<>();
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        slow = head;
        while (!stack.isEmpty()) {
            if (slow.value != stack.pop().value) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean IsPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = InverseList(slow);
        slow = head;
        head = fast;
        while (fast != null) {
            if (slow.value != fast.value) {
                InverseList(head);
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        InverseList(head);
        return true;
    }

    public static Node InverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindrome1(head) + " | ");
        System.out.print(IsPalindrome2(head) + " | ");
        System.out.println(IsPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println();
        System.out.println("=========================");

    }
}
