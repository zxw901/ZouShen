package basic_class_03;

public class Code_14_SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node SmallerEqualBigger(Node head, int pivot) {
        Node lessH = null;
        Node lessE = null;
        Node moreH = null;
        Node moreE = null;
        Node equalH = null;
        Node equalE = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (lessH == null) {
                    lessH = head;
                    lessE = head;
                } else {
                    lessE.next = head;
                    lessE = head;
                }

            } else if (head.value > pivot) {
                if (moreH == null) {
                    moreH = head;
                    moreE = head;
                } else {
                    moreE.next = head;
                    moreE = head;
                }

            } else {
                if (equalH == null) {
                    equalH = head;
                    equalE = head;
                } else {
                    equalE.next = head;
                    equalE = head;
                }
            }
            head = next;
        }
        if (lessE != null) {
            lessE.next = equalH;
            equalE = equalE == null ? lessE : equalE;
        }
        if (equalE != null) {
            equalE.next = moreH;
        }
        return lessH != null ? lessH : equalH != null ? equalH : moreH;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = SmallerEqualBigger(head1, 5);
        printLinkedList(head1);

    }
}
