package Linked;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
