package Linked;

/**
 * 环形链表2
 */
public class Hot100_142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 第一步：找相遇点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // 第一次相遇
                // 第二步：找入口点
                ListNode index1 = fast; // 相遇点
                ListNode index2 = head; // 链表头
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1; // 再次相遇点即为入口
            }
        }
        return null; // 无环
    }
}
