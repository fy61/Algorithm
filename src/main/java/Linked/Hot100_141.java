package Linked;

/**
 * 环形链表
 */
public class Hot100_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;        // 走1步
            fast = fast.next.next;   // 走2步

            if (slow == fast) {      // 相遇了，说明有环
                return true;
            }
        }
        return false;
    }
}
