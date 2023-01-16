package in_place_linkedlist_reversal;

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public static void printList(LinkedListNode node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
     }
}
