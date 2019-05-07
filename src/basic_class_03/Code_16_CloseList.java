package basic_class_03;

public class Code_16_CloseList {
    public static class Node {
        public int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        } else {
            return null;
        }
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int num = 0;
        while (cur1.next != null) {
            num++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            num--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = num > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        num = Math.abs(num);
        while (num != 0) {
            cur1 = cur1.next;
            num--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        if (loop1 == loop2) {
            Node cur1 = head1;
            Node cur2 = head2;
            int num = 0;
            while (cur1 != loop1) {
                num++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                num--;
                cur2 = cur2.next;
            }
            cur1 = num > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            num = Math.abs(num);
            while (num != 0) {
                cur1 = cur1.next;
                num--;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            Node tmp1 = loop1;
            while (loop1 != loop2) {
                loop1 = loop1.next;
                if (loop1 == tmp1) {
                    return null;
                }
            }
            return loop1;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
